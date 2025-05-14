package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdk.jfr.Event;

public class Sign_In {
    public Sign_In() {
    }

    @FXML
    private Button SignIn;
    @FXML
    private Button CreateNewAccBtn;
    @FXML
    private Button BackBtn;
    @FXML
    private TextField UsernameTextfil ;
    @FXML
    private PasswordField PasswordTextfld;

//public void SignIncliked(){
//
//    System.out.println("Sign In Button Clicked");
//   String user =   UsernameTextfil.getText();
//    String pass = PasswordTextfld.getText();
//    if(user.equals("") && pass.equals("")){
//        System.out.println("Empty Fields");
//    }
//    System.out.println(user);
//    System.out.println(pass);
//    //remember to check for null
//}
@FXML
private void SignIncliked(ActionEvent event)throws Exception {
    SceneSwitcher.switchScene(event, "/org/example/sakan_db/AdminPage.fxml");

}

public void createBtncliked(){
    System.out.println("Create Button Clicked");

    SceneSwitcher.switchScene(null, "/org/example/sakan_db/CreateNew.fxml");



}
public void BackBtncliked(){
    System.out.println("Back Button Clicked");
}

}
