package org.example.sakan_db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Report.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("SAKAN");
        stage.setScene(scene);
        stage.show();
        testFXMLLoading();
    }

    public static void main(String[] args) {
        launch();
    }


    public void testFXMLLoading() {
        var url = getClass().getResource("/org/example/sakan_db/AddForSale.fxml");
        if (url == null) {
            System.out.println("❌ FXML not found");
        } else {
            System.out.println("✅ Found FXML at: " + url);
        }
    }

}