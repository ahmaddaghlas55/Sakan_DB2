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

public class ForSale {
    public ForSale() {
    }
    @FXML
    private ComboBox<Integer> PorpertyID ;
    @FXML
    private ComboBox<Integer> CustomerID ;
    @FXML
    private DatePicker DateDay ;
    @FXML
    private TextField cashAmoutTF ;
    @FXML
    private Button AddNewSale ;
    @FXML
    private Button BackBtn ;
    @FXML
    private Button EditSale ;
    @FXML
    private Button DeleteSale ;


    public void NewSale(){
        System.out.println("Add New Sale Button Clicked");
        Integer propertyID = PorpertyID.getValue();
        Integer customerID = CustomerID.getValue();
        String date = DateDay.getValue().toString();
        String cashAmount = cashAmoutTF.getText();
        if(propertyID == null || customerID == null || date.equals("") || cashAmount.equals("")){
            System.out.println("Empty Fields");
            return;
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
    public void Edit(){
        System.out.println("Edit Sale Button Clicked");
    }
    public void Delete(){
        System.out.println("Delete Sale Button Clicked");
    }



}
