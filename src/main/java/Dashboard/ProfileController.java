package Dashboard;
import AdminDB.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ProfileController {
    ProfileController(){
        System.out.println("vai");
    }

    @FXML
    private ImageView cirimage;

    @FXML
    private Label district;

    @FXML
    private Label division;

    @FXML
    private Label mail;

    @FXML
    private Label name;

    @FXML
    private Label phone;

    @FXML
    private Circle pic;

    @FXML
    private Label role;
    public String username="";


    public void set(String username) {
        this.username = username;
    }
    @FXML
    void chatclick(ActionEvent event) {
        System.out.println(username);

    }





}
