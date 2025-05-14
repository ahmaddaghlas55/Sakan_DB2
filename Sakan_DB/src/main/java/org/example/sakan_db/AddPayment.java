package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
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


    public void AddNewPayment(){
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

        int customerID = customerIDValue;
        int propertyID = propertyIDValue;

        System.out.println(amount);
        System.out.println(date);
        System.out.println(caseID);
        System.out.println(customerID);
        System.out.println(propertyID);

        // Clear fields
        PaymentAmountTF.setText("");
        DataSelect.setValue(null);
        CasePaymentIDTF.setText("");
        CustomerIDJBox.setValue(null);
        PropertyJIDBox.setValue(null);
    }
    public void BackBtncliked(){
        System.out.println("Back Button Clicked");
    }
    public void EditPayment(){
        System.out.println("Edit Payment Button Clicked");
    }
    public void DeletePayment(){
        System.out.println("Delete Payment Button Clicked");
    }
    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");
        // Navigate back to Report screen
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Report.fxml");
    }
}

