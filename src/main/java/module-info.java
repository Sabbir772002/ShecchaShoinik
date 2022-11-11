module com.example.sheccashoinik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sheccashoinik to javafx.fxml;
    exports com.example.sheccashoinik;

    opens Sign_in to javafx.fxml;
    exports Sign_in;
    opens Sign_UP to javafx.fxml;
    exports Sign_UP;
    opens DB to javafx.fxml;
    exports DB;
    opens AdminDB to javafx.fxml;
    exports AdminDB;
}
