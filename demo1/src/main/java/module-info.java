module org.test.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.test.demo1 to javafx.fxml;
    exports org.test.demo1;
}