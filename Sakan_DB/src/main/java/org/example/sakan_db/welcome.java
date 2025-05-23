package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.IOException;

public class welcome {



    @FXML
    public Button AdminBtn;
    @FXML
    public Button CustomerBtn;

    @FXML
    private void onAdminClick(ActionEvent event) throws IOException {
        System.out.println("Admin button clicked - navigating to AdminPage");
        UserRoleFlag.role = "admin"; // SET THE FLAG
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/SignIn.fxml");
    }

    @FXML
    private void onCustomerClick(ActionEvent event) throws IOException {
        System.out.println("User button clicked - navigating to AddCustomer");
        UserRoleFlag.role = "user";
       // SceneSwitcher.switchScene(event, "/org/example/sakan_db/AddCustomer.fxml");//will be changed
        JOptionPane.showMessageDialog(null, "will be added later");

    }

}