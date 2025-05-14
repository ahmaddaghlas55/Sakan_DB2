package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class AddProperty {
    public AddProperty() {
    }

    @FXML
    private TextField ContryTF;
    @FXML
    private TextField numOfRoomTF;
    @FXML
    private TextField PriceTF;
    @FXML
    private TextField StreetTF;
    @FXML
    private TextField phoneNumberTF;
    @FXML
    private TextField CityTF;
    @FXML
    private Button AddPhotoBtn;
    @FXML
    private Button AddPropertyBtn;
    @FXML
    private Button EditPropertyBtn;
    @FXML
    private Button DeletePropertyBtn;
    @FXML
    private Button BackBtn;
    @FXML
    private RadioButton FLatRadBtn;
    @FXML
    private RadioButton HouseRadBtn;
    private String imagePath = "";
    private Boolean isFlat = false;
    private Boolean isHouse = false;

    public void flatBtnpressed(){
        System.out.println("Flat Button Pressed");
        isFlat = true;
    }

    public void HouseBtnPreesed(){
        System.out.println("House Button Pressed");
        isHouse = true;
    }

    public void AddProperty(){
        System.out.println("Add Property Button Clicked");

        String country = ContryTF.getText();
        String numOfRoom = numOfRoomTF.getText();
        String price = PriceTF.getText();
        String street = StreetTF.getText();
        String phoneNumber = phoneNumberTF.getText();
        String city = CityTF.getText();
        boolean isFlat = FLatRadBtn.isSelected();
        boolean isHouse = HouseRadBtn.isSelected();

        if (country.equals("") && numOfRoom.equals("") && price.equals("") &&
                street.equals("") && phoneNumber.equals("") && city.equals("")) {
            System.out.println("Empty Fields");
            return;
        }

        if ((isFlat && isHouse) || (!isFlat && !isHouse)) {
            System.out.println("Please select only one property type: either Flat or House.");
            return;
        }

        System.out.println(country);
        System.out.println(numOfRoom);
        System.out.println(price);
        System.out.println(street);
        System.out.println(phoneNumber);
        System.out.println(city);
        System.out.println("Is Flat: " + isFlat);
        System.out.println("Is House: " + isHouse);

        // Clear fields
        ContryTF.setText("");
        numOfRoomTF.setText("");
        PriceTF.setText("");
        StreetTF.setText("");
        phoneNumberTF.setText("");
        CityTF.setText("");
        FLatRadBtn.setSelected(false);
        HouseRadBtn.setSelected(false);
    }

    public void EditPropertyBtncliked(){
        System.out.println("Edit Property Button Clicked");
    }

    public void DeletePropertyBtncliked(){
        System.out.println("Delete Property Button Clicked");
    }

    public void AddPhoto(){
        System.out.println("Upload Image Button Clicked");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image for the property");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            System.out.println("Selected Image Path: " + imagePath);
        } else {
            System.out.println("No image selected.");
        }
    }

    @FXML
    public void BackBtncliked(ActionEvent event) throws IOException {
        System.out.println("Back Button Clicked");
        // Navigate back to Report screen
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/Report.fxml");
    }
}