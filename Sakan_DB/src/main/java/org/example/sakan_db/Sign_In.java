package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdk.jfr.Event;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sign_In {
    public Sign_In() {
    }

    @FXML
    public void initialize() {
        WrongPassword.setVisible(false);
    }

    @FXML
    public Button SignIn;
    @FXML
    public Button CreateNewAccBtn;
    @FXML
    public Button BackBtn;
    @FXML
    public TextField UsernameTextfil;
    @FXML
    public PasswordField PasswordTextfld;
    @FXML
    public Label WrongPassword;


    @FXML
    private void SignIncliked(ActionEvent event) throws Exception {
        String username = UsernameTextfil.getText().trim();
        String password = PasswordTextfld.getText().trim();
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username or Password is empty");
            WrongPassword.setVisible(true);
            return;
        }

        Connection conn = DBUtil.getConnection();// love this
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "";

            if (UserRoleFlag.role.equals("admin")) {
                query = "SELECT * FROM sakanadmin WHERE adminname = ? AND adminpassword = ?";
            } else if (UserRoleFlag.role.equals("user")) {
                query = "SELECT * FROM sakanuser WHERE username = ? AND userpassword = ?"; // Assuming you have a user table like this
            }

            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                storeAdminData.setAdminName(username);

                String imagePathFromDB = rs.getString("adminpic");
                System.out.println("Image path from DB: " + imagePathFromDB);

                if (imagePathFromDB != null && imagePathFromDB.startsWith("file:/")) {
                    imagePathFromDB = new File(new java.net.URI(imagePathFromDB)).getAbsolutePath();
                }

                if (imagePathFromDB != null && new File(imagePathFromDB).exists()) {
                    String copiedPath = copyImageToLocalFolder(imagePathFromDB);
                    System.out.println("Copied path: " + copiedPath);
                    storeAdminData.setAdminImagePath(copiedPath);
                } else {
                    System.out.println("⚠️ Original image not found: " + imagePathFromDB);
                }

                if (UserRoleFlag.role.equals("admin")) {
                    SceneSwitcher.switchScene(event, "/org/example/sakan_db/AdminPage.fxml");
                } else if (UserRoleFlag.role.equals("user")) {
                    JOptionPane.showMessageDialog(null, "will be added later");

                }
            } else {
                System.out.println("Invalid username or password");
                WrongPassword.setVisible(true);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    public void createBtncliked(ActionEvent event) throws Exception {
        System.out.println("Create Button Clicked");

        SceneSwitcher.switchScene(event, "/org/example/sakan_db/CreateNew.fxml");


    }

    @FXML
    public void BackBtn(ActionEvent event) throws Exception {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Welcome.fxml");

    }
        //take image and store in resources
        public static String copyImageToLocalFolder(String sourcePath) {
            try {
                File source = new File(sourcePath);
                File destDir = new File("user_data/img");
                if (!destDir.exists()) destDir.mkdirs();

                File dest = new File(destDir, source.getName());

                try (FileInputStream fis = new FileInputStream(source);
                     FileOutputStream fos = new FileOutputStream(dest)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }

                return dest.getPath(); // ✅ return the new copied path

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

}
