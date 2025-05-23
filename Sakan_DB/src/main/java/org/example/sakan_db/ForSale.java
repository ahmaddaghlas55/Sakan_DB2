package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ForSale {
    public ForSale() {

    }

    @FXML
    public void initialize() {
        loadCustomerIDs();
        loadForSalePropertyIDs();
        PorpertyID.setOnAction(e -> loadPropertyPrice());
        //loadPropertyPrice();

    }
    @FXML
    public ComboBox<Integer> PorpertyID ;
    @FXML
    public ComboBox<Integer> CustomerID ;
    @FXML
    public DatePicker DateDay ;
    @FXML
    public TextField cashAmoutTF ;
    @FXML
    public Button AddNewSale ;
    @FXML
    public Button BackBtn ;

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
                CustomerID.getItems().add(customerId);
            }

        } catch (Exception e) {
            System.out.println("Error loading customer IDs: " + e.getMessage());
        }
    }

    private void loadForSalePropertyIDs() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "doom";

        String query = "SELECT property_ID FROM sakanproperty ";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int propertyId = rs.getInt("property_ID");
                PorpertyID.getItems().add(propertyId);
            }

        } catch (Exception e) {
            System.out.println("Error loading property IDs: " + e.getMessage());
        }
    }

    private void loadPropertyPrice() {
        Integer propertyId = PorpertyID.getValue();
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
                cashAmoutTF.setText(String.valueOf(price));
            }

        } catch (Exception e) {
            System.out.println("Error loading property price: " + e.getMessage());
        }
    }


    public void NewSale(){
        System.out.println("Add New Sale Button Clicked");
        Integer propertyID = PorpertyID.getValue();
        Integer customerID = CustomerID.getValue();
        String date = DateDay.getValue().toString();
        cashAmoutTF.getText().trim();
        cashAmoutTF.setEditable(false);

        String cashAmount = cashAmoutTF.getText();
        if(propertyID == null || customerID == null || date.equals("") || cashAmount.equals("")){
            System.out.println("Empty Fields");
            return;
        }
        try{

            Connection conn = DBUtil.getConnection();
            String tstmt = "INSERT INTO sakanpropertysale(property_ID, customer_ID, dateofpurchase, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(tstmt);
            stmt.setInt(1, propertyID);
            stmt.setInt(2, customerID);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setDouble(4, Double.parseDouble(cashAmount));
            stmt.executeUpdate();


        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }


        System.out.println(""+propertyID+" "+customerID+" "+date+" "+cashAmount+" ");
        PorpertyID.setValue(null);
        CustomerID.setValue(null);
        DateDay.setValue(null);
        cashAmoutTF.setText("");
    }

    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");

        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Report.fxml");
        
        
    }




}
