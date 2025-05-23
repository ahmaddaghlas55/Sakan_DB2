package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class AddPayment {
    public AddPayment() {
    }
    @FXML
    private TextField PaymentAmountTF;
    @FXML
    private DatePicker DataSelect;
    @FXML
    private TextField CasePaymentIDTF;
    @FXML
    private ChoiceBox<Integer> CustomerIDJBox;// ID is Intger
    @FXML
    private ChoiceBox<Integer> PropertyJIDBox;



    @FXML
    public void initialize(){
        PropertyJIDBox.setOnAction(event -> loadPropertyPrice());
        loadCustomerIDs();
        loadPropertyIDs();

    }





        //this function will load the price to the text field so we don't need to remember the price of the property :)
    private void loadPropertyPrice() {
        Integer propertyId = PropertyJIDBox.getValue();
        if (propertyId == null) return;

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "doom";

        String query = "SELECT propertyprice FROM sakanproperty WHERE property_ID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, propertyId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Integer price = rs.getInt("propertyprice");//postgres.public.sakanproperty.propertyprice
                PaymentAmountTF.setText(String.valueOf(price));
            }

        } catch (Exception e) {
            System.out.println("Error loading property price: " + e.getMessage());
        }
    }


    private void loadCustomerIDs() {


        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "doom";

        String query = "SELECT customer_ID FROM sakancustomer";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int customerId = rs.getInt("customer_ID");
                CustomerIDJBox.getItems().add(customerId);
            }

        } catch (Exception e) {
            System.out.println("Error loading customer IDs: " + e.getMessage());
        }
    }

    private void loadPropertyIDs() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "doom";

        String query = "SELECT property_ID FROM sakanproperty ";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int propertyId = rs.getInt("property_ID");
                PropertyJIDBox.getItems().add(propertyId);
            }

        } catch (Exception e) {
            System.out.println("Error loading property IDs: " + e.getMessage());
        }
    }


    @FXML
    public void AddNewPayment(ActionEvent event)throws IOException
            {//where is the action listener?

        System.out.println("Add New Payment Button Clicked");

        String amount = PaymentAmountTF.getText();
        LocalDate dateValue = DataSelect.getValue();
        String date = (dateValue != null) ? dateValue.toString() : "";
        String caseID = CasePaymentIDTF.getText();

        Integer customerIDValue = CustomerIDJBox.getValue();
        Integer propertyIDValue = PropertyJIDBox.getValue();

        if(amount.equals("") || date.equals("") || caseID.equals("") ||
                customerIDValue == null || propertyIDValue == null) {
            System.out.println("Empty Fields");
            return;
        }

        try
        {

            Connection conn = DBUtil.getConnection();
            String stmt= "Insert into sakanpayment(customer_id,cashpayment_id,property_id,amount,paymentdate) values(?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setInt(1, customerIDValue);
            pstmt.setInt(2, Integer.parseInt(caseID));
            pstmt.setInt(3, propertyIDValue);
            pstmt.setInt(4, Integer.parseInt(caseID));
            pstmt.setDate(5, Date.valueOf(date));
            pstmt.executeUpdate();
            pstmt.close();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



        System.out.println(amount);
        System.out.println(date);
        System.out.println(caseID);
        System.out.println(customerIDValue);
        System.out.println(propertyIDValue);





        // Clear fields
        PaymentAmountTF.setText("");
        DataSelect.setValue(null);
        CasePaymentIDTF.setText("");
        CustomerIDJBox.setValue(null);
        PropertyJIDBox.setValue(null);
    }

    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");
        // Navigate back to Report screen
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/AdminPage.fxml");
    }
}

