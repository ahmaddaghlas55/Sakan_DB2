package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//import javax.swing.text.html.ImageView;
import javafx.scene.image.ImageView; // ✅ Correct JavaFX import

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Admin{
    public Admin(){}

    @FXML
    private void initialize(){
        LocalDate currentDate = LocalDate.now();
        todayDate.setText(currentDate.toString()); // Formats as "2025-05-23"
        todayDate.setPrefWidth(200);
        AdminName.setText(storeAdminData.getAdminName());

        String imagePath = storeAdminData.getAdminImagePath();
        System.out.println("Loading admin image from: " + imagePath);

        if (imagePath != null && new File(imagePath).exists()) {
            Image img = new Image(new File(imagePath).toURI().toString());
            admin_pic.setImage(img);
        } else {
            System.out.println("⚠️ Copied image not found or path is null");
        }



    }

    @FXML
    public Button addCustomerBtn;

    @FXML
    public Button addPropertyBtn;
    @FXML
    public Button addOwnerBtn;
    @FXML
    public Button addPaymentBtn;
    @FXML
    public Button showReportBtn;
    @FXML
    public Label todayDate;
    @FXML
    public Label AdminName;

    @FXML
    public ImageView admin_pic;







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
    private void HomeCliked(ActionEvent event) {
      //  switchScene(event, "/org/example/sakan_db/AdminPage.fxml");
        switchScene("/org/example/sakan_db/AdminPage.fxml", event);
    }

    @FXML
    private void Customerclikced(ActionEvent event) throws IOException {
      //  switchScene(event, "/org/example/sakan_db/views/AddCustomer.fxml");
        switchScene("/org/example/sakan_db/AddCustomer.fxml", event);
    }

    @FXML
    private void propertyCliked(ActionEvent event) throws IOException {
       // System.out.println("Property Button Clicked");
      //  switchScene(event, "/org/example/sakan_db/views/AddProperty.fxml");
        switchScene("/org/example/sakan_db/AddProperty.fxml", event);

    }

    @FXML
    private void OwnerCliked(ActionEvent event) throws IOException {
      //  switchScene(event, "/org/example/sakan_db/views/AddOwner.fxml");
        switchScene("/org/example/sakan_db/AddOwner.fxml", event);
    }

    @FXML
    private void PaymentCliked(ActionEvent event) throws IOException {
       // switchScene(event, "/org/example/sakan_db/views/AddPayment.fxml");
        switchScene("/org/example/sakan_db/AddPayment.fxml", event);
    }

    @FXML
    private void ReporteCliked(ActionEvent event) throws IOException {
       // switchScene(event, "/org/example/sakan_db/views/Report.fxml");
        switchScene("/org/example/sakan_db/report.fxml", event);
    }

    @FXML
    private void ForSaleCliked(ActionEvent event) throws IOException {
      //  switchScene(event, "/org/example/sakan_db/views/ForSale.fxml");
        switchScene("/org/example/sakan_db/ForSale.fxml", event);
    }



}