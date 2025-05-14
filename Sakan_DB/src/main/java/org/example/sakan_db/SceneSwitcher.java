package org.example.sakan_db;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneSwitcher {
//    public static void switchScene(ActionEvent event, String fxmlFile) {
//        try {
//            Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFile));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void switchScene(ActionEvent event, String fxmlFile) {
        try {
            URL fxmlUrl = SceneSwitcher.class.getResource(fxmlFile);
            if (fxmlUrl == null) {
                throw new IOException("FXML file not found: " + fxmlFile +
                        "\nMake sure it exists in the resources folder and the path is correct.\n" +
                        "Expected at: src/main/resources" + fxmlFile);
            }

            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.err.println("⚠️ Failed to load FXML file: " + fxmlFile);
            System.err.println("➡️ Reason: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Unexpected error while switching scenes.");
            e.printStackTrace();
        }
    }
}