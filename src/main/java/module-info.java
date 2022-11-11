module com.example.shecchashoinik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.shecchashoinik to javafx.fxml;
    exports com.example.shecchashoinik;
  opens AdminDashboard to javafx.fxml;
  exports AdminDashboard;
    opens Sign_in to javafx.fxml;
    exports Sign_in;
    opens Sign_UP to javafx.fxml;
    exports Sign_UP;
    opens Dashboard to javafx.fxml;
    exports Dashboard;
}
