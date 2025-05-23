package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class AddProperty {
    public AddProperty() {
    }


    @FXML
    public void initialize() {
        loadOwnersIDs();
    }

    @FXML
    public TextField property_ID;

    @FXML
    public TextField ContryTF;
    @FXML
    public TextField numOfRoomTF;
    @FXML
    public TextField PriceTF;
    @FXML
    public TextField StreetTF;
    @FXML
    public TextField phoneNumberTF;
    @FXML
    public TextField CityTF;
    @FXML
    public Button AddPhotoBtn;
    @FXML
    public Button AddPropertyBtn;

    public Button BackBtn;
    @FXML
    public RadioButton FLatRadBtn;
    @FXML
    public RadioButton HouseRadBtn;

    @FXML
    public ChoiceBox<Integer>OwnerBox;

    private String imagePath = "";
    private Boolean isFlat = false;
    private Boolean isHouse = false;
        private String propertyType = "";


    private void loadOwnersIDs() {


        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "doom";

        String query = "SELECT owner_id FROM sakanowner";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int customerId = rs.getInt("owner_id");
                OwnerBox.getItems().add(customerId);
            }

        } catch (Exception e) {
            System.out.println("Error loading owners IDs: " + e.getMessage());
        }
    }



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
        String propertyID = property_ID.getText();// it's a intger btw
        String country = ContryTF.getText();
        String numOfRoom = numOfRoomTF.getText();
        String price = PriceTF.getText().trim();
        String street = StreetTF.getText();
        String phoneNumber = phoneNumberTF.getText().trim();
        String city = CityTF.getText();
        String ownerID = OwnerBox.getValue().toString();
        boolean isFlat = FLatRadBtn.isSelected();
        boolean isHouse = HouseRadBtn.isSelected();

        if (country.equals("") || numOfRoom.equals("") || price.equals("") ||
                street.equals("") || phoneNumber.equals("") || city.equals("")) {
            System.out.println("Empty Fields");//must be a red lable & do not delete the data :)
            return;
        }

        if ((isFlat && isHouse) || (!isFlat && !isHouse)) {
            System.out.println("Please select only one property type: either Flat or House.");
            return;
        }
        if (isFlat) {
            propertyType = "Flat";
        }
        if (isHouse) {
            propertyType = "House";
        }

        System.out.println(country);
        System.out.println(numOfRoom);
        System.out.println(price);
        System.out.println(street);
        System.out.println(phoneNumber);
        System.out.println(city);
        System.out.println("Is Flat: " + isFlat);
        System.out.println("Is House: " + isHouse);

        try {
            Connection conn = DBUtil.getConnection();// love this
            PreparedStatement stmt = null;
            ResultSet rs = null;

//            String url = "jdbc:postgresql://localhost:5432/postgres";
//            String user = "postgres";
//            String password = "doom";
//
//            Connection conn = DriverManager.getConnection(url, user, password);
//            conn.setAutoCommit(false);

            String insertSQL = "INSERT INTO sakanproperty (property_ID,propertytype, numberofrooms, propertyprice, propertyphonenumber, propertycity, propertycountry,propertypic,owner_id ) VALUES (?,?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, Integer.parseInt(property_ID.getText()));
           pstmt.setString(2, propertyType);
            pstmt.setInt(3, Integer.parseInt(numOfRoom));
            pstmt.setInt(4, Integer.parseInt(price));
            pstmt.setInt(5, Integer.parseInt(phoneNumber));
            pstmt.setString(6, city);
            pstmt.setString(7, country);
            pstmt.setString(8, imagePath);
            pstmt.setInt(9, Integer.parseInt(ownerID));

            pstmt.executeUpdate();
           // conn.commit();
            pstmt.close();
            conn.close();

            System.out.println("Property added successfully!");

            // Clear fields
            ContryTF.setText("");
            numOfRoomTF.setText("");
            PriceTF.setText("");
            phoneNumberTF.setText("");
            CityTF.setText("");
            FLatRadBtn.setSelected(false);
            HouseRadBtn.setSelected(false);


        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }



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
        SceneSwitcher.switchScene(event, "/org/example/sakan_db/AdminPage.fxml");
    }
}