package org.example.sakan_db.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.sakan_db.SceneSwitcher;

import java.io.IOException;

public class Admin{
    @FXML private Button addCustomerBtn;
    @FXML private Button addPropertyBtn;
    @FXML private Button addOwnerBtn;
    @FXML private Button addPaymentBtn;
    @FXML private Button showReportBtn;

    @FXML
    private void onAddCustomerClick(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/AddCustomer.fxml");
    }

    @FXML
    private void onAddPropertyClick(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/AddProperty.fxml");
    }

    @FXML
    private void onAddOwnerClick(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/AddOwner.fxml");
    }

    @FXML
    private void onAddPaymentClick(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/AddPayment.fxml");
    }

    @FXML
    private void onShowReportClick(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/views/Report.fxml");
    }
}