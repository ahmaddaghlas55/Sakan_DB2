package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Report {

    @FXML
    private Label AdminName;

    @FXML
    private Label todayDate;

    @FXML
    private TextField SearchBar;

    @FXML
    private Button HomeBtn;
    @FXML
    private Button AddCustomerBtn;
    @FXML
    private Button AddPropertyBtn;
    @FXML
    private Button AddOwnerBtn;
    @FXML
    private Button AddPaymentBtn;
    @FXML
    private Button AddForSaleBtn;
    @FXML
    private Button ShowRepodtBtn;
    @FXML
    private Button ShowPaymentReportBtn;
    @FXML
    private Button ShowPropertyReportBtn;
    @FXML
    private Button ShowCustomerReportBtn;
    @FXML
    private Button SearchBtn;

    private void switchScene(String fxmlFile, ActionEvent event) {
        try {
          //  Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onHomeClick(ActionEvent event) {
        switchScene("/org/example/sakan_db/AdminPage.fxml", event);
    }

    @FXML
    private void Customerclikced(ActionEvent event) {
        switchScene("/org/example/sakan_db/AddCustomer.fxml", event);
    }

    @FXML
    private void propertyCliked(ActionEvent event) {
        switchScene("/org/example/sakan_db/AddProperty.fxml", event);
    }

    @FXML
    private void OwnerCliked(ActionEvent event) {
        switchScene("/org/example/sakan_db/AddOwner.fxml", event);
    }

    @FXML
    private void PaymentCliked(ActionEvent event) {
        switchScene("/org/example/sakan_db/AddPayment.fxml", event);
    }

    @FXML
    private void ForSaleCliked(ActionEvent event) {
        switchScene("/org/example/sakan_db/ForSale.fxml", event);
    }

    @FXML
    private void ReporteCliked(ActionEvent event) {
        switchScene("/org/example/sakan_db/report.fxml", event);
    }

    @FXML
    private void PaymentReporty(ActionEvent event) {
        switchScene("/org/example/sakan_db/paymentReport.fxml", event);
    }

    @FXML
    private void propertyReport(ActionEvent event) {
        switchScene("/org/example/sakan_db/propertyReport.fxml", event);
    }

    @FXML
    private void CustomerReport(ActionEvent event) {
        switchScene("/org/example/sakan_db/customerReport.fxml", event);
    }

    @FXML
    private void SearchCliked(ActionEvent event) {
        String keyword = SearchBar.getText();
        System.out.println("Searching for: " + keyword);
        // Optional: Implement search logic here
    }
}
