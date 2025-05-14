package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddCustomer {
    public AddCustomer() {
    }
    @FXML
private Button AddCustomerBtn;
    @FXML
    private Button EditCustomerBtn;
    @FXML
    private Button DeleteCustomerBtn;
    @FXML
    private Button BackBtn;
    @FXML
    private TextField CustomerIDTF ;// TF stand for text field
    @FXML
    private TextField CustomerNameTF ;
    @FXML
    private TextField CustomerPNTF ;
    @FXML
    private TextField CustomerEmailTF ;
    @FXML
    private PasswordField CustomerPassTF ;

public void AddNewCustomer(){
    System.out.println("Add New Customer Button Clicked");
    String id = CustomerIDTF.getText();
    String name = CustomerNameTF.getText();
    String phone = CustomerPNTF.getText();
    String email = CustomerEmailTF.getText();
    String pass = CustomerPassTF.getText();
    if(id.equals("") && name.equals("") && phone.equals("") && email.equals("") && pass.equals("")){
        System.out.println("Empty Fields");
    }
    System.out.println(id);
    System.out.println(name);
    System.out.println(phone);
    System.out.println(email);
    System.out.println(pass);

    // Clear the text fields
    CustomerIDTF.setText("");
    CustomerNameTF.setText("");
    CustomerPNTF.setText("");
    CustomerEmailTF.setText("");
    CustomerPassTF.setText("");

    //the System.out.println will print the value of the text field
    //must replace these with the code to insert the data into the database typeshit

}
public void EditCustomerBtncliked(){
    System.out.println("Edit Customer Button Clicked");
    /*this will open a new window to edit the customer
    * the idea is to select the customer from the database and edit it
    * if you can make the edite in the same window as the add new customer
    * you will get a kiss */


}
public void DeleteCustomerBtncliked(){
    System.out.println("Delete Customer Button Clicked");
    /*same as edit customer but just delete the customer from the database spreed love not legs */
}
    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");

        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Report.fxml");


    }



}
