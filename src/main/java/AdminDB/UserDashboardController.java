package AdminDB;
import java.awt.Desktop;
import BloodBank.BloodBankController;
import Chat.ChatHandle;
import Chat.ChatPrivateController;
import Chat.CommunityChatHandelar;
import Chat.LiveHandeler;
import DB.ConnectionDb;
import Event.ViewEvent;
import Others.HRequest;
import Others.HelpRequest;
import Others.VolunteerNearController;
import PostBox.Post;
//import PostBox.SinglePostController;
import PostBox.SinglePostController;
import UserProfile.ProfileController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import com.example.sheccashoinik.disaster;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import org.controlsfx.control.*;

public class UserDashboardController implements Initializable {
    Connection con=ConnectionDb.DBC();
    public UserDashboardController(){
       con=ConnectionDb.DBC();

    }

    public void set(String username, String role) {
        con=ConnectionDb.DBC();
        user.setText(username);
        rolee.setText("@" + role);
        this.role = role;
        this.username = username;
        alertcount();
        alertnum.setText(String.valueOf(newcount));
        Thread t=new AlertThread();
        t.start();
       // loadtable0();
    }
    class AlertThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    //  System.out.println("hey ami choltesi");
                    Thread.sleep(1000);
                    alertcount();
                    if(newcount!=oldcount){

                       /* PauseTransition wait = new PauseTransition(Duration.seconds(1));
                        wait.setOnFinished((e) -> {
                            alertnum.setText(String.valueOf(newcount));
                            wait.playFromStart();
                        });
                        wait.play();*/

                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }


            }
        }

    }
    @FXML
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




    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private ScrollPane spane;

    @FXML
    private TableView<disaster> table;
    @FXML
    private TableColumn<disaster, String> col_address;

    @FXML
    private TableColumn<disaster, String> col_district;

    @FXML
    private TableColumn<disaster, String> col_title;

    @FXML
    private TableColumn<disaster, String> col_type;

    @FXML
    private TableColumn<disaster, Integer> col_id;
    @FXML
    private TextField textfield;

    ObservableList<disaster> listF;

    @FXML
    void keyclick(KeyEvent e) {
        ObservableList<disaster> list = FXCollections.observableArrayList();
        //i++;
        if (e.getCode() != KeyCode.ENTER) {
            return;
        }
        if (e.getCode() == KeyCode.ENTER) {
            Connection con = ConnectionDb.DBC();
            //ObservableList<diaster>list = FXCollections.observableArrayList();
            try {
                /*PreparedStatement ps =  con.prepareStatement(
                        "SELECT * FROM `diasterlist` WHERE" +
                                      " Division='"+textfield.getText().toString()
                                    +"' OR District='"+textfield.getText().toString()
                                    +"' OR `Title`='"+textfield.getText().toString()
                                    +"' OR `Type`='"+textfield.getText().toString()
                                    +"' OR `Address`='"+textfield.getText().toString()
                                    +"' OR `AddInfo`='"+textfield.getText().toString()
                                    +"' OR `Id`='"+textfield.getText().toString()
                                    +"' ORDER BY Id DESC;");*/
                PreparedStatement ps = con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
                ResultSet rs = ps.executeQuery();
                // +"' OR `Title`='"+textfield.getText().toString()
               /* ps.setString(1,textfield.getText().toString());
                ps.setString(2,textfield.getText().toString());*/
                // ps.setString(1,textfield.getText().toString());
                while (rs.next()) {
                    String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (rs.getInt(6)) + "", rs.getString(7)};
                    String s1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5] + " " + s[6];
                    //String s5[] = s1.split(" ");

                    String s2 = textfield.getText().toString() + "";
                    // System.out.println(s2);
                    boolean i = false;
                    for (int j = 0; j < s1.length(); j++) {
                        for(int p = j+1; p < s1.length()-1; p++) {
                            // System.out.println(textfield.getText().toString());
                            // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/
                            if (s1.substring(j, p).equalsIgnoreCase(s2)) {
                                // System.out.println((s[j])+"=="+textfield.getText().toString());
                                i = true;
                            }
                        }
                    }
                    s2 += " ";
                    if (s2.equals("")) {
                        i = true;
                        // System.out.println("thik ase");
                    }
                    if (s2.equals(" ")) {
                        i = true;
                        //System.out.println("thik ase2");
                    }
                    if (i) {
                        list.add(new disaster(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6]));
                    }

                }
                // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
            } catch (Exception ie) {
                System.out.println("error at disaster backlist");
            } finally {

                try {
                    con.close();
                } catch (Exception ee) {
                }
            }
            listF = list;
            loadtable1();
        } else {
            //i=0;
            System.out.println("onk bar cole code");
            loadtable();
        }


    }
    @FXML
    void search(ActionEvent e) {
        ObservableList<disaster> list = FXCollections.observableArrayList();
        //i++;


            Connection con = ConnectionDb.DBC();
            //ObservableList<diaster>list = FXCollections.observableArrayList();
            try {
                /*PreparedStatement ps =  con.prepareStatement(
                        "SELECT * FROM `diasterlist` WHERE" +
                                      " Division='"+textfield.getText().toString()
                                    +"' OR District='"+textfield.getText().toString()
                                    +"' OR `Title`='"+textfield.getText().toString()
                                    +"' OR `Type`='"+textfield.getText().toString()
                                    +"' OR `Address`='"+textfield.getText().toString()
                                    +"' OR `AddInfo`='"+textfield.getText().toString()
                                    +"' OR `Id`='"+textfield.getText().toString()
                                    +"' ORDER BY Id DESC;");*/
                PreparedStatement ps = con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
                ResultSet rs = ps.executeQuery();
                // +"' OR `Title`='"+textfield.getText().toString()
               /* ps.setString(1,textfield.getText().toString());
                ps.setString(2,textfield.getText().toString());*/
                // ps.setString(1,textfield.getText().toString());
                while (rs.next()) {
                    String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (rs.getInt(6)) + "", rs.getString(7)};
                    String s1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5] + " " + s[6];
                    String s5[] = s1.split(" ");

                    String s2 = textfield.getText().toString() + "";
                    // System.out.println(s2);
                    boolean i = false;
                    for (int j = 0; j < s1.length(); j++) {
                        for(int p = j+1; p < s1.length()-1; p++) {
                            // System.out.println(textfield.getText().toString());
                            // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/
                            if (s1.substring(j, p).equalsIgnoreCase(s2)) {
                                // System.out.println((s[j])+"=="+textfield.getText().toString());
                                i = true;
                            }
                        }
                    }
                    s2 += " ";
                    if (s2.equals("")) {
                        i = true;
                        // System.out.println("thik ase");
                    }
                    if (s2.equals(" ")) {
                        i = true;
                        //System.out.println("thik ase2");
                    }
                    if (i) {
                        list.add(new disaster(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6]));
                    }

                }
                // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
            } catch (Exception ie) {
                System.out.println("error at disaster backlist");
            } finally {

                try {
                    con.close();
                } catch (Exception ee) {
                }
            }
            listF = list;
            loadtable1();



    }
    //for user search
   /* ObservableList<userlist>list = FXCollections.observableArrayList();
            try {
        PreparedStatement ps =  con.prepareStatement("SELECT Name,Username FROM `userlist`");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            //String Title,Type, Address, Division, District, Id,AddInfo
            list.add(new userlist(rs.getString(1), rs.getString(2))); //rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
        }
    } catch (Exception e) {
        System.out.println("error at db userlist");
    }finally{

        try {
            con.close();
        } catch (Exception e) {
        }
    }*/

    void loadtable1() {
        col_title.setCellValueFactory(new PropertyValueFactory<disaster, String>("Title"));
        col_type.setCellValueFactory(new PropertyValueFactory<disaster, String>("Type"));
        col_district.setCellValueFactory(new PropertyValueFactory<disaster, String>("District"));
        col_address.setCellValueFactory(new PropertyValueFactory<disaster, String>("Address"));
        col_id.setCellValueFactory(new PropertyValueFactory<disaster, Integer>("Id"));

        //table.setItems(list);
        //listF=list;
        table.setItems(listF);

    }

    ObservableList<disaster> getdiasterList() {
        ObservableList<disaster> diasterlist1 = FXCollections.observableArrayList();


        return diasterlist1;
    }

    int indexM = -1;

    void loadtable() {
        col_title.setCellValueFactory(new PropertyValueFactory<disaster, String>("Title"));
        col_type.setCellValueFactory(new PropertyValueFactory<disaster, String>("Type"));
        col_district.setCellValueFactory(new PropertyValueFactory<disaster, String>("District"));
        col_address.setCellValueFactory(new PropertyValueFactory<disaster, String>("Address"));
        col_id.setCellValueFactory(new PropertyValueFactory<disaster, Integer>("Id"));
        //table.setItems(list);
        listF = ConnectionDb.getdiasterlist();
        table.setItems(listF);


    }

    @FXML
    void Dashboard(ActionEvent event) {
        loadtable();

        //System.out.println("vaiya ki khobor "+username);
     /*   try {
            AdminDB.FXMLScene scene = FXMLScene.load("UserDashboard.fxml");
            Parent root = scene.root;
            UserDashboardController admin = (UserDashboardController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("User Dashboard");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo Dashboard button userdashboard controller");
        }*/
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.HomeboardController.class.getResource("HomeBoard.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HomeboardController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {


        //for cheking purposes only
                  /*  VBox vbox[]=new VBox[3];
                    for(int i =0;i<3;i++) {
                        p = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                        vbox[i]=new VBox();
                        vbox[i].getChildren().add(p);
                        *//*stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("SIGN IN");
                        stage.show();*//*

                    }
                    //AnchorPane apane = new AnchorPane();
                    HBox a = new HBox();
                    a.getChildren().add(vbox);
                    pane1.setCenter(vbox);
            */


    }

    @FXML
    void mailbox(){
        try {

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://wa.me/880"+"1571144383"));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    @FXML
    void G(ActionEvent event) {
    }

    @FXML
    void Event(ActionEvent event) {
       /* try {
            Event.FXMLScene scene = Event.FXMLScene.load("ViewEvent.fxml");
            Parent root = scene.root;
            Event.ViewEvent admin = (Event.ViewEvent) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Event");
            stage.show();
        } catch (IOException e) {
            System.out.println("vul hoilo Event button userdashboard controller " + e.getMessage());
        }*/
        try{
            //System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Event.ViewEvent.class.getResource("ViewEvent.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ViewEvent sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            //System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void hrequest(ActionEvent event) {
        /*try {
            Others.FXMLScene scene = Others.FXMLScene.load("HelpRequest1.fxml");
            Parent root = scene.root;
            Others.HelpRequest admin = (Others.HelpRequest) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Event");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo hrequest button userdashboard controller " + e.getMessage());
        }*/
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.HelpRequest.class.getResource("HelpRequest.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HRequest sadmin = fxmlLoader.getController();
            sadmin.set(username,role);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @FXML
    void vnear(ActionEvent event) {
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.VolunteerNearController.class.getResource("VolunteerNear.fxml"));
            AnchorPane ap = fxmlLoader.load();
            VolunteerNearController sadmin = fxmlLoader.getController();
            sadmin.set(username,role);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        /*try {
            Shoinik.FXMLScene scene = Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin = (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Volunteer Near Me");
            stage.show();
        } catch (IOException e) {
            System.out.println("vul hoilo F button userdashboard1 controller " + e.getMessage());
        }*/

    }


    @FXML
    void chat(ActionEvent event) {
        /*try {
            Chat.FXMLScene scene = Chat.FXMLScene.load("CommunityChat.fxml");
            Parent root = scene.root;
            //System.out.println("chat cole na");
            Chat.CommunityChatHandelar admin = (Chat.CommunityChatHandelar) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo chat button Userdashboard controller " + e.getMessage());
        }*/

        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
           // fxmlLoader.setLocation(Chat.ChatPrivateController.class.getResource("CommunityChat.fxml"));
            fxmlLoader.setLocation(Chat.LiveHandeler.class.getResource("ServerChat.fxml"));
            AnchorPane ap = fxmlLoader.load();
           // CommunityChatHandelar sadmin = fxmlLoader.getController();

            LiveHandeler sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void logout(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout Confirmation");
            alert.setHeaderText("Are you sure you want to log out?");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            // alert.initOwner(stage);
            //alert.setGraphic(new ImageView(image));
            //user.setImage(image);
            Optional<ButtonType> result = alert.showAndWait();
            if (alert.getResult().getText().equals("OK")) {
                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    void BbankClick(ActionEvent event) {
       /* System.out.println("hlw ki bank");
        try {
            BloodBank.FXMLScene scene = BloodBank.FXMLScene.load("BloodBank.fxml");
            Parent root = scene.root;
            BloodBankController admin = (BloodBankController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo profile button Userdashboard controller " + e.getMessage());
        }*/
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(BloodBankController.class.getResource("BloodBank.fxml"));
            AnchorPane ap = fxmlLoader.load();
            BloodBankController sadmin = fxmlLoader.getController();
            sadmin.set(username,role);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @FXML
    void profile(ActionEvent event) {

     /*   try {
            UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin = (ProfileController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo profile button Userdashboard controller " + e.getMessage());
        }*/

        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void ChoiceClick(MouseEvent event) {
        if (choice.getValue().toString().equals("Logout")) {
            try {
                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Choiceclick(ActionEvent event) {
        if(choice.getValue()==null){
            return;
        }
        if (choice.getValue().toString().equals("Logout")) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Logout Confirmation");
                alert.setHeaderText("Are you sure you want to log out?");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                // alert.initOwner(stage);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result = alert.showAndWait();
                if (alert.getResult().getText().equals("OK")) {
                    root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("SIGN IN");
                    stage.show();
                }
                //choice.getSelectionModel().

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try{
               // System.out.println("hey ki khobor");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
                AnchorPane ap = fxmlLoader.load();
                ProfileController sadmin = fxmlLoader.getController();
                sadmin.set(username,role,pane1);
                pane1.setCenter(ap);
                //System.out.println("kno holo na");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }

    @FXML
    void addpost(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(PostBox.AddPostController.class.getResource("AddPost.fxml"));
            AnchorPane ap = fxmlLoader.load();
            AddPostController sadmin = fxmlLoader.getController();
            sadmin.set(username,role);
            pane1.setCenter(ap);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @FXML
    private Label rolee;

    @FXML
    private ImageView search;

    @FXML
    private Label user;

    int oldcount = 0,newcount = 0;
    @FXML
    ImageView alertimage;

    @FXML
    private Button alertbutton;
    @FXML
    private Button btsearch;
    @FXML
    private GridPane pane;
/*    public void set(String username, String role) {
        con=ConnectionDb.DBC();
        user.setText(username);
        rolee.setText("@" + role);
        this.role = role;
        this.username = username;
        alertcount();
        alertnum.setText(String.valueOf(newcount));
        Thread t=new AlertThread();
        t.start();
        loadtable();
    }*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView = new ImageView(new Image(new File("src/main/Font/notify.png").toURI().toString()));
        imageView.setFitHeight(25);
        imageView.setFitWidth(27);
        ImageView imageView0 = new ImageView(new Image(new File("src/main/Font/search.png").toURI().toString()));
        imageView0.setFitHeight(20);
        imageView0.setFitWidth(25);
        btsearch.setGraphic(imageView0);
        alertbutton.setGraphic(imageView);
        //alertimage.setImage(new Image(new File("src/main/Font/notify.png").toURI().toString()));
        String[] choiceb = {"Profile", "Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1.png");
        Image image1 = new Image(file1.toURI().toString());
        bimage.setImage(image1);
        file1 = new File("src/main/Font/logotext.png");
        Image image4 = new Image(file1.toURI().toString());
        logoimage.setImage(image4);
        file1 = new File("src/main/Font/icon1.png");
        Image image5 = new Image(file1.toURI().toString());
        imageview1.setImage(image5);
        file1 = new File("src/main/Font/search.png");
        Image image6 = new Image(file1.toURI().toString());
        col_address.setStyle("-fx-text-fill: #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER-LEFT;");
        col_district.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER;");
        col_id.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold; -fx-alignment:CENTER;");
        col_title.setStyle("-fx-text-fill: #400401;-fx-border-color:transparent; -fx-padding: 10 5 10 5; -fx-font-weight: bold; -fx-alignment:CENTER-LEFT; ");
        col_type.setStyle("-fx-text-fill: #400401;-fx-alignment:CENTER; -fx-font-weight:bold; -fx-text-size: 14;");
        //search.setImage(image6);
        loadtable();
        /*PauseTransition wait = new PauseTransition(Duration.seconds(1));
        wait.setOnFinished((e) -> {
            alertnum.setText(String.valueOf(newcount));
            wait.playFromStart();
        });
        wait.play();*/

    }
   ArrayList<post> list;
    ArrayList<post> loaddata(){
        list=new ArrayList<post>();
        File file=new File("im.png");
        try {
        FileOutputStream fos=new FileOutputStream(file);
        byte pic[];
        Blob blob;

            PreparedStatement ps =  con.prepareStatement("SELECT Title,Type,Address,District,ID,Image FROM diasterlist Order by Id Desc;");
            ;
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //String Title,Type, Address, Division, District, Id,AddInfo
                blob = rs.getBlob("Image");
                pic = blob.getBytes(1, (int) blob.length());
                fos.write(pic);
               // System.out.println("ami ashlam");
               // ImageView image=new ImageView(new Image(file.toURI().toString()));
                list.add(new post((rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),pic));


                // con.close();
            }} catch (Exception e) {
            System.out.println("error at bd backlist");
        }


       return list;
    }
    public class post {
        public String Title,Type, Address, Division, District,AddInfo;
        int Id;
        public ImageView image;
        public String s;
        byte[] b;

        public byte[] getB() {
            return b;
        }

        public void setB(byte[] b) {
            this.b = b;
        }



        public FileOutputStream getOutput() {
            return output;
        }

        public void setOutput(FileOutputStream output) {
            this.output = output;
        }

        FileOutputStream output;
        File file;
        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }



        public String getIs() {
            return s;
        }
        public String sets() {
            return s;
        }

        public void getImage(ImageView image) {
            this.image = image;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getType() {
            return Type;
        }

        public String getAddInfo() {
            return AddInfo;
        }

        public void setAddInfo(String addInfo) {
            AddInfo = addInfo;
        }

        public String getDistrict() {
            return District;
        }

        public void setDistrict(String district) {
            District = district;
        }

        public void setDivision(String division) {
            Division = division;
        }

        public String getDivision() {
            return Division;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public void setType(String type) {
            Type = type;
        }

        public post(String Title, String Type, String Address, String Division, String District, int Id, String AddInfo) {
            this.Title = Title;
            this.Type = Type;
            this.Address = Address;
            this.Division = Division;
            this.District = District;
            this.Id = Id;
            this.AddInfo = AddInfo;



        }
        public post(String Title, String Type, String Address,String District, int Id,byte[]b) {
            this.Title = Title;
            this.Type = Type;
            this.Address = Address;
           // this.Division = Division;
            this.District = District;
            this.Id = Id;
            this.b = b;
          //  this.AddInfo = AddInfo;



        }
    }
    void loadtable0() {
        list=loaddata();
      //  listF = ConnectionDb.getdiasterlist();
        //table.setItems(listF);
       //List = new ArrayList<>(productList());
        int column = 1;
        int row = 1;
        try{
            for(post product : list){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(PostBox.SinglePostController.class.getResource("SinglePost.fxml"));
                VBox productBox = fxmlLoader.load();
                 SinglePostController sadmin = fxmlLoader.getController();
                 sadmin.set(pane1);
                 sadmin.loadtable0(product,username,role);
                if(column == 3){
                    column = 1;
                    ++row;
                }
                pane.add(productBox, column++, row);
                GridPane.setMargin(productBox, new Insets(15));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //table.setItems(list);



    }
    int oldct=0;
    int z=0;
    void alertcount( )  {
      try{
          int allpost=0;
          int i=0;
          PreparedStatement ps = con.prepareStatement("SELECT Id FROM `diasterlist` ORDER BY Id DESC;");
          ResultSet rs = ps.executeQuery();
          while(rs.next()) {
         i++;
         allpost=rs.getInt(1);
              //System.out.println(allpost);
         if(i==1){
             break;
         }
         if(z==0){
             oldct=allpost;
             z++;
         }

          }
          rs.close();
          ps.close();
          //PreparedStatement ps1 = con.prepareStatement("SELECT Postid FROM `notify` Where Username ='"+username+"';");
          String s="SELECT Postid FROM `notify` Where Username='"+username+"'";
          //System.out.println(s);
          PreparedStatement ps1 = con.prepareStatement(s);
          ResultSet rs1 = ps1.executeQuery();
        int j=0;
        while(rs1.next()) {
            rs1.getInt(1);
            j++;

        }
        ps1.close();
        rs1.close();
         // System.out.println(allpost);
        //  System.out.println("kaj korlo na");
        newcount =allpost-j;
        if(oldcount==newcount){
            //System.out.println("Old= "+oldcount+" New= "+newcount);
        }else {
            //System.out.println("Old= "+oldcount+" New= "+newcount);
            //alertnum.setText(newcount+"");
            oldcount = newcount;
            PauseTransition wait = new PauseTransition(Duration.seconds(1));
            wait.setOnFinished((e) -> {
                alertnum.setText(String.valueOf(newcount));
                // Notifications.create().title("New Disaster Posted!").text("Please check home page!").position(Pos.TOP_LEFT).showInformation();

                wait.playFromStart();
            });
            wait.play();

/*
PauseTransition wait1 = new PauseTransition(Duration.seconds(1));
            wait1.setOnFinished((e) -> {
              //  alertnum.setText(String.valueOf(newcount));
               Notifications.create().title("New Disaster Posted!").text("Please check home page!").position(Pos.TOP_LEFT).showInformation();

                wait1.playFromStart();
            });
            wait1.play();
            Thread.sleep(1000);
            wait1.stop();
        }
*/
        }


      }catch( Exception e ){
          System.out.println(e.getMessage());

      }

    }
    @FXML
    void alert(ActionEvent e){
        loadtable();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New Post Notification");
        System.out.println(oldct);
        alert.setHeaderText("("+(Integer.parseInt(alertnum.getText().toString())-oldct)+") New post added!");
        File file = new File("src/main/Font/icon1.png");
        Image image = new Image(file.toURI().toString());
        stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(image);
        // alert.initOwner(stage);
        //alert.setGraphic(new ImageView(image));
        //user.setImage(image);
        Optional<ButtonType> result = alert.showAndWait();
        System.out.println("hey ki khobor");
        oldct=Integer.parseInt(alertnum.getText().toString());
        System.out.println(oldct);

        //System.out.println("vaiya ki khobor "+username);
     /*   try {
            AdminDB.FXMLScene scene = FXMLScene.load("UserDashboard.fxml");
            Parent root = scene.root;
            UserDashboardController admin = (UserDashboardController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("User Dashboard");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo Dashboard button userdashboard controller");
        }*/
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.HomeboardController.class.getResource("HomeBoard.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HomeboardController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);

        }catch (Exception ee){
            System.out.println(ee.getMessage());
        }
        System.out.println("vai amare marse");

    }
@FXML
    void tableclick(MouseEvent event) {
    //System.out.println(table.getSelectionModel().getSelectedItem().getId());
    try {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(PostBox.Post.class.getResource("PostView.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Post sadmin = fxmlLoader.getController();
            //sadmin.set(username,role);


            sadmin.set(username, role, table.getSelectionModel().getSelectedItem().getId(),pane1);
            pane1.setCenter(ap);
            Connection con = ConnectionDb.DBC();
            try {
                String sql = "SELECT * FROM notify Where username = ? and Postid = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, table.getSelectionModel().getSelectedItem().getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    PreparedStatement ps1 = con.prepareStatement("insert into `notify`  (Username,Postid) values (?,?);");
                    // ResultSet rs1= ps1.executeQuery();
                    ps1.setString(1, username);
                    ps1.setInt(2, table.getSelectionModel().getSelectedItem().getId());
                    ps1.execute();
                    ps1.close();
                    //rs1.close();
                } else {
                    ;
                    System.out.println("ase aita");
                }
                resultSet.close();
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }



        }
    }