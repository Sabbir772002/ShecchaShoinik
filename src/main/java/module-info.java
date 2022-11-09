module com.example.shecchashoinik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shecchashoinik to javafx.fxml;
    exports com.example.shecchashoinik;

    opens Sign_in to javafx.fxml;
    exports Sign_in;
    opens Sign_UP to javafx.fxml;
    exports Sign_UP;
}
