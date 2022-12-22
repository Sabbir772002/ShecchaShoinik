package Others;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class VolunteerApproveController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";


    public void set(String username,String role) {
        this.role = role;
        this.username = username;
    }
    BorderPane pane;

    public void set(String username, String role, BorderPane pane) {
        this.pane=pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
    }


}
