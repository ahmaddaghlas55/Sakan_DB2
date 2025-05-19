module org.test.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.test.demo to javafx.fxml;
    exports org.test.demo;
}