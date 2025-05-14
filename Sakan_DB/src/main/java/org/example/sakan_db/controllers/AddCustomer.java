package org.example.sakan_db.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.sakan_db.SceneSwitcher;

import java.io.IOException;

public class AddCustomer {
    @FXML private TextField customerIdTF;
    @FXML private TextField customerNameTF;
    @FXML private TextField phoneNumberTF;
    @FXML private TextField emailTF;
    @FXML private PasswordField passwordTF;
    @FXML private Button addBtn;
    @FXML private Button backBtn;

    @FXML
    private void handleAddCustomer() {
        System.out.println("Adding customer:");
        System.out.println("ID: " + customerIdTF.getText());
        System.out.println("Name: " + customerNameTF.getText());
        System.out.println("Phone: " + phoneNumberTF.getText());
        System.out.println("Email: " + emailTF.getText());

        // Clear fields
        customerIdTF.clear();
        customerNameTF.clear();
        phoneNumberTF.clear();
        emailTF.clear();
        passwordTF.clear();
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/AdminPage.fxml");
    }
}