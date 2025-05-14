package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class welcome {
    @FXML
    private Button AdminBtn;
    @FXML
    private Button CustomerBtn;

    @FXML
    private void onAdminClick(ActionEvent event) throws IOException {
        System.out.println("Admin button clicked - navigating to AdminPage");
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/SignIn.fxml");
    }

    @FXML
    private void onCustomerClick(ActionEvent event) throws IOException {
        System.out.println("User button clicked - navigating to AddCustomer");
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/AddCustomer.fxml");
    }

}