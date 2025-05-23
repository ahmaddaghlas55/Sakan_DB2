package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddOwner {
    public AddOwner() {
    }

    @FXML
    private TextField OwnerIDTF;
    @FXML
    private TextField OwnernameT;
    @FXML
    private TextField OwnerpnTF;
    @FXML
    private TextField OwnerAddressTF;
    @FXML
    private TextField OwnerEmailTF;
    @FXML
    private TextField OwnerPassTF;
    @FXML
    private Button AddOwnerBtn;
    @FXML
    private Button BackBtn;
    @FXML
    private Button EditOwnerBtn;
    @FXML
    private Button DeleteOwnerBtn;



    public void NewOwner(){
        System.out.println("Add Owner Button Clicked");
        String id = OwnerIDTF.getText();
        String name = OwnernameT.getText();
        String phone = OwnerpnTF.getText();
        String address = OwnerAddressTF.getText();
        String email = OwnerEmailTF.getText();
        String pass = OwnerPassTF.getText();
        if(id.equals("") && name.equals("") && phone.equals("") && email.equals("") && pass.equals("")){
            System.out.println("Empty Fields");
        }
        System.out.println(id);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(email);
        System.out.println(pass);
        OwnerAddressTF.setText("");
        OwnerEmailTF.setText("");
        OwnerPassTF.setText("");
        OwnerIDTF.setText("");
        OwnernameT.setText("");
        OwnerpnTF.setText("");


        /* i feel you know what should you do */




    }


    public void BackBtncliked(){
        System.out.println("Back Button Clicked");
    }
    public void EditOwner(){
        System.out.println("Edit Owner Button Clicked");

    }
    public void DeleteOwner(){
        System.out.println("Delete Owner Button Clicked");

    }

    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");
        // Navigate back to Report screen
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Report.fxml");
    }








}
