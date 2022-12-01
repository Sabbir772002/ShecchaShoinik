module com.example.sheccashoinik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens UserDashboard to javafx.fxml;
    exports UserDashboard;

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

    opens UserProfile to javafx.fxml;
    exports UserProfile;

    opens Post to javafx.fxml;
    exports Post;
    exports TeamProfile;
    opens TeamProfile to javafx.fxml;
}
