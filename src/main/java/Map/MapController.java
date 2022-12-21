package Map;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.disaster;
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
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class MapController {
    public MapController() throws FileNotFoundException {
        con= ConnectionDb.DBC();
    }
    String s;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
    int id;
    Connection con;
    @FXML
    private WebView view;

    @FXML
    private Label addinfo;

    @FXML
    private Label address;

    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private Button bt1;

    @FXML
    private ChoiceBox<String> choice;

    String district;

    String division;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private BorderPane pane1;


    @FXML
    private Label rolee;

    @FXML
    private Text title;


    @FXML
    private Label user;
    String post[]=new String[6];
    File file=new File("im.png");
    FileOutputStream fos=new FileOutputStream(file);
    byte pic[];
    Blob blob;
    disaster dlist = null;

    public void set(String username,String role,int id) {
        System.out.println("i am in set");
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.id=id;
       title.setText(dlist.getTitle());
        //type.setText(dlist.getType());
         address.setText(dlist.getAddress());
         district=dlist.getDistrict();

        s="<html>\n" +
                "\n" +
                "<head>\n" +
                "    <title>Google Map</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"mapouter\">\n" +
                "    <div class=\"gmap_canvas\">\n" +
                "        <iframe class=\"gmap_iframe\" width=\"100%\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\"\n" +
                "                src=\"https://maps.google.com/maps?width=721&amp;height=621&amp;hl=en&amp;q="+address.getText().toString()+","+district+"&amp;t=&amp;z=12&amp;ie=UTF8&amp;iwloc=B&amp;output=embed\"></iframe>\n" +
                "        <a href=\"https://embedmapgenerator.com\">google maps code generator</a>\n" +
                "    </div>\n" +
                "    <style>\n" +
                ".mapouter{\n" +
                "           position:relative;text-align:right;width:100%;height:621px;\n" +
                "}\n" +
                ".gmap_canvas {\n" +
                "       overflow:hidden;background:none!important;width:100%;height:621px;\n" +
                "}\n" +
                ".gmap_iframe {\n" +
                "height:621px!important;\n" +
                "}</style>\n" +
                "</div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
        engine.loadContent(s);
    }

    @FXML
    void viewmap(ActionEvent e){
        //System.out.println("ashlam kaj holo na1");
        try{
            System.out.println("ashlam kaj holo na");
            Map.FXMLScene scene =  Map.FXMLScene.load("MapD.fxml");
            Parent root = scene.root;
            Map.MapController admin= (Map.MapController) scene.controller;
            // admin.set(username,role,id);
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Maps");
            stage.show();
        }catch(Exception et){
            System.out.println("vul hoilo viewmap button post controller "+et.getMessage());
        }


    }
    @FXML
    public void gomap(ActionEvent actionEvent) {
        WebEngine engine = view.getEngine();
        engine.loadContent(s);

    }
}
