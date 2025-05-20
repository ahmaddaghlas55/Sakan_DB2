package org.example.sakan_db;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.sakan_db.TableClasss.Sakanadmin;

import javax.swing.plaf.synth.Region;
import java.io.File;

public class CreateNew {
    public CreateNew() {
    }
    private Boolean Admin = false;
    private Boolean User = false;
    private String imagePath = "";


    @FXML
   private TextField UsernameTextFld;
    @FXML
    private PasswordField PasswordTextFld;
    @FXML
    private RadioButton SeleAdminRadBtn;
    @FXML
    private RadioButton SeleCUstomerRadBtn;
    @FXML
    private Button UploadImageBtn;
    @FXML
    private Button CreatNewBtn;
    @FXML
    private Button BackBtn;
    public void UploadImageBtncliked(){
        System.out.println("Upload Image Button Clicked");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");

        // Optional: Limit file types to images
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Open file chooser
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString(); // Or use getAbsolutePath() if preferred
            System.out.println("Selected Image Path: " + imagePath);
        } else {
            System.out.println("No image selected.");
        }
    }
    public void CreatNewBtncliked(){
        System.out.println("Create Account Button Clicked");

        String user = UsernameTextFld.getText();
        String pass = PasswordTextFld.getText();

        boolean isAdminSelected = SeleAdminRadBtn.isSelected();
        boolean isUserSelected = SeleCUstomerRadBtn.isSelected();

        if (user.isEmpty() || pass.isEmpty()) {
            System.out.println("Username or Password is empty.");
            return;
        }

        if ((isAdminSelected && isUserSelected) || (!isAdminSelected && !isUserSelected)) {
            System.out.println("Error: Select only one role (Admin or User).");
            return;
        }

        if (isAdminSelected) {
            System.out.println("Admin Account Created");
            System.out.println("Username: " + user);
            System.out.println("Password: " + pass);
            System.out.println("Image Path: " + imagePath);
     /*  Sakanadmin ne = new Sakanadmin();
          try {
              ne.setAdminname(user);  //this is i way to get the code maybe :)
          }
          catch (Exception e){
              System.out.println("Error: " + e);
          }*/
            // Save or process Admin account here
        } else if (isUserSelected) {
            System.out.println("User Account Created");
            System.out.println("Username: " + user);
            System.out.println("Password: " + pass);
            System.out.println("Image Path: " + imagePath);
            // Save or process User account here
        }
        //remember to check for null


        //clear textFiled
        UsernameTextFld.setText("");
        PasswordTextFld.setText("");
        SeleAdminRadBtn.setSelected(false);
        SeleCUstomerRadBtn.setSelected(false);
        imagePath = "";


    }
    public void BackBtncliked(){
        System.out.println("Back Button Clicked");
    }
    public void SeleAdminRadBtnCl(){
    System.out.println("Admin Button Clicked");
        Admin = true;
    }
    public void SeleCUstomerRadBtnC(){
    System.out.println("User Button Clicked");
    User = true;
    }








}
