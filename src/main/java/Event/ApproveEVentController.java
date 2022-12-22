package Event;

import AdminDB.AdminDashboardController;
import AdminDB.FXMLScene;
import AdminProfile.AdminProfileController;
import BloodBank.BloodBankController;
import DB.ConnectionDb;
import Others.TeamApproveController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.disaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ApproveEVentController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";


    public void set(String username,String role) {

        this.role = role;
        this.username = username;
    }
    @FXML
    void Decline(ActionEvent event) {

    }



}


