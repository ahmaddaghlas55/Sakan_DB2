module org.example.sakan_db {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires jdk.jfr;
    requires java.sql;

    opens org.example.sakan_db to javafx.fxml;
    exports org.example.sakan_db;
    exports org.example.sakan_db.controllers;
    opens org.example.sakan_db.controllers to javafx.fxml;
    exports org.example.sakan_db.TableClasss;
    opens org.example.sakan_db.TableClasss to javafx.fxml;

}
