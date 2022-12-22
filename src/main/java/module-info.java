module com.example.sheccashoinik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.web;
    //requires javafx.controlsfx.controls;

    exports UserProfile;

    opens com.example.sheccashoinik to javafx.fxml;
    exports com.example.sheccashoinik;

    opens BloodBank to javafx.fxml;
    exports BloodBank;

    opens Profile to javafx.fxml;
    exports Profile;

    opens Sign_in to javafx.fxml;
    exports Sign_in;

    opens Sign_UP to javafx.fxml;
    exports Sign_UP;

    opens DB to javafx.fxml;
    exports DB;

    opens AdminDB to javafx.fxml;
    exports AdminDB;

    opens PostBox to javafx.fxml;
    exports PostBox;

    opens TeamProfile to javafx.fxml;
    exports TeamProfile;

    opens Chat to javafx.fxml;
    exports Chat;

    opens  Others to javafx.fxml;
    exports Others;

    opens ExtraFeature to javafx.fxml;
    exports ExtraFeature;

    opens Shoinik to javafx.fxml;
    exports Shoinik;

    opens Event to javafx.fxml;
    exports Event;
    opens Map to javafx.fxml;
    exports Map;
    opens TeamPostBox to javafx.fxml;
    exports TeamPostBox;


}
