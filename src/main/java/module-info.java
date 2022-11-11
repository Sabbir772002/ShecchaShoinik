module com.example.shecchashoinik {
    requires javafx.controls;
    requires javafx.fxml;


    opens Shecchashoinik to javafx.fxml;
    exports Shecchashoinik;

    opens Sign_in to javafx.fxml;
    exports Sign_in;
    opens Sign_UP to javafx.fxml;
    exports Sign_UP;
    opens Dashboard to javafx.fxml;
    exports Dashboard;
    opens AdminDashboard to javafx.fxml;
    exports AdminDashboard;
}
