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
    private void AdminbtnClicked(ActionEvent event) throws IOException {
        System.out.println("Admin button clicked - navigating to AdminPage");
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/AdminPage.fxml");
    }

    @FXML
    private void UserbtnClicked(ActionEvent event) throws IOException {
        System.out.println("User button clicked - navigating to AddCustomer");
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/AddCustomer.fxml");
    }

    public void onAdminClick(ActionEvent actionEvent) {
    }

    public void onCustomerClick(ActionEvent actionEvent) {
    }

    public void AddNewCustomer(ActionEvent actionEvent) {
    }

    public void EditCustomerBtncliked(ActionEvent actionEvent) {
    }

    public void DeleteCustomerBtncliked(ActionEvent actionEvent) {
    }

    public void BackBtncliked(ActionEvent actionEvent) {
    }

    public void Customerclikced(ActionEvent actionEvent) {
    }

    public void propertyCliked(ActionEvent actionEvent) {
    }

    public void OwnerCliked(ActionEvent actionEvent) {
    }

    public void PaymentCliked(ActionEvent actionEvent) {
    }

    public void ForSaleCliked(ActionEvent actionEvent) {
    }

    public void ReporteCliked(ActionEvent actionEvent) {
    }

    public void SearchCliked(ActionEvent actionEvent) {
    }

    public void HomeCliked(ActionEvent actionEvent) {
    }
}