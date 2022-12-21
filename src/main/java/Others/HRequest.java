package Others;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.Connection;

public class HRequest {

    @FXML
    private TextField Address;

    @FXML
    private TextField Extra;

    @FXML
    private TextField address;

    @FXML
    private ComboBox<?> district;

    @FXML
    private ComboBox<?> division;

    @FXML
    private ComboBox<?> division1;

    @FXML
    private Button imageup;

    @FXML
    void Submit(ActionEvent event) {

    }

    @FXML
    void select(ActionEvent event) {

    }

    @FXML
    void upimage(ActionEvent event) {

    }
    Connection con;
    //=ConnectionDb.DBC();
    private BorderPane pane1;
    @FXML
    private Label alertnum;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ImageView imageview;
    @FXML
    private ImageView bimage;

    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username = "";
    public String role = "";

 String user="";
 String rolee="";

    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        user=username;
        role=role;
        this.role = role;
        this.username = username;
        address.setText(username);
       // alertcount();
        //alertnum.setText(String.valueOf(newcount));
       // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }

}
