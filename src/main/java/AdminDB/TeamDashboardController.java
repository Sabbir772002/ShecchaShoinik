package AdminDB;

import BloodBank.BloodBankController;
import Chat.CommunityChatHandelar;
import Chat.LiveHandeler;
import DB.ConnectionDb;
import Event.ViewEvent;
import News.NewsBox;
import Others.*;
import PostBox.AddPostController;
import PostBox.Post;
import Sign_in.SigninController;
import TeamProfile.TeamProfileController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.disaster;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeamDashboardController implements Initializable {

    @FXML
    private BorderPane pane1;

    Connection con;
    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ImageView imageview;
    @FXML
    Button bbutton;


    @FXML
    void BbankClick(ActionEvent event) {
        try{
            //System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(BloodBankController.class.getResource("BloodBank.fxml"));
            AnchorPane ap = fxmlLoader.load();
            BloodBankController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private Button b;
    @FXML
    private Button bt1;



   /* @FXML
    private ChoiceBox<?> choice;

    @FXML
    private ImageView imageview;
*/

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";

    @FXML
    private TextField textfield;
    @FXML
    void searchfiled(KeyEvent e) {
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
        } else {
            //i=0;
            System.out.println("onk bar cole code");
            loadtable();
        }
    }

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    void News(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(NewsBox.class.getResource("NewsBox.fxml"));
            AnchorPane ap = fxmlLoader.load();
            NewsBox sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane1);
            pane1.setCenter(ap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        @FXML
    void Event(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Event.ViewEvent.class.getResource("ViewEvent.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ViewEvent sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
        } catch (IOException e) {
            System.out.println("vul hoilo Event button Teamshboard controller " + e.getMessage());
        }

    }
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
    ObservableList<disaster> listF;
    //int i=0;
    @FXML
    void search(KeyEvent e) {
        ObservableList<disaster> list=FXCollections.observableArrayList();
        //i++;
        if(e.getCode() != KeyCode.ENTER){return;}
        if(e.getCode() == KeyCode.ENTER){
            Connection con =ConnectionDb.DBC();
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
                while(rs.next()){
                    String s[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),(rs.getInt(6))+"",rs.getString(7)};
                   String s1=s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+s[4]+" "+s[5]+" "+s[6];
                      String s5[]= s1.split(" ");

                    String s2=textfield.getText().toString()+"";
                    System.out.println(s2);
                    boolean i=false;
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
                    if(s2.equals("")){
                        i=true;
                        System.out.println("thik ase");
                    }
                    if(s2.equals(" ")){
                        i=true;
                        System.out.println("thik ase2");
                    }
                   if(i) {
                       list.add(new disaster(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6]));
                   }

                }
               // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
            } catch (Exception ie) {
                System.out.println("error at disaster backlist");
            }finally{

                try {
                    con.close();
                } catch (Exception  ee) {
                }
            }
            listF=list;
            loadtable1();
        }else{
            //i=0;
            System.out.println("onk bar cole code");
            loadtable();
        }


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

    void loadtable1(){
        col_title.setCellValueFactory(new PropertyValueFactory<disaster,String>("Title"));
        col_type.setCellValueFactory(new PropertyValueFactory<disaster,String>("Type"));
        col_district.setCellValueFactory(new PropertyValueFactory<disaster,String>("District"));
        col_address.setCellValueFactory(new PropertyValueFactory<disaster,String>("Address"));
        col_id.setCellValueFactory(new PropertyValueFactory<disaster,Integer>("Id"));

        //table.setItems(list);
        //listF=list;
        table.setItems(listF);

    }


    ObservableList<disaster> getdisasterList(){
        ObservableList<disaster> disasterlist1 = FXCollections.observableArrayList();


        return disasterlist1;
    }
    int indexM = -1;

    void loadtable(){
        col_title.setCellValueFactory(new PropertyValueFactory<disaster,String>("Title"));
        col_type.setCellValueFactory(new PropertyValueFactory<disaster,String>("Type"));
        col_district.setCellValueFactory(new PropertyValueFactory<disaster,String>("District"));
        col_address.setCellValueFactory(new PropertyValueFactory<disaster,String>("Address"));
        col_id.setCellValueFactory(new PropertyValueFactory<disaster,Integer>("Id"));

        //table.setItems(list);
        listF = ConnectionDb.getdiasterlist();
        table.setItems(listF);

    }

    @FXML
    void Dashboard(ActionEvent event) {
        loadtable();
        //System.out.println("bhaiya ki khobor? "+username);
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.HomeboardController.class.getResource("HomeBoard.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HomeboardController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
        }catch (Exception e){
            System.out.println("bhul hoilo team dashboard controller dashboard");
        }

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {



        //for checking purposes only
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
    void hresponse(ActionEvent event) {
        try{
            System.out.println("hey hresponse");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.HelpResponseController.class.getResource("HelpResponse.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HelpResponseController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
        }catch (Exception e){
            System.out.println("Bhul hoilo team dashboard button Help response controller "+e.getMessage());
        }


    }

    @FXML
    void task(ActionEvent event) {
        try{
            System.out.println("hey task");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.VolunteerList.class.getResource("VolunteerList.fxml"));
            AnchorPane ap = fxmlLoader.load();
            VolunteerList sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
        }catch (Exception e){
            System.out.println("bhul hoilo team dashboard button task  controller "+e.getMessage());
        }

    }


    @FXML
    void vapprove(ActionEvent event) {
        try{
            System.out.println("hey hresponse");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.VolunteerApproveController.class.getResource("VolunteerApprovee.fxml"));
            AnchorPane ap = fxmlLoader.load();
            VolunteerApproveController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
        }catch (Exception e){
            System.out.println("Bhul hoilo V approve button Team controller "+e.getMessage());
        }

    }

    @FXML
    void Vnear(ActionEvent event) {
        try {
            System.out.println("hey hresponse");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Others.VolunteerNearController.class.getResource("VolunteerNear.fxml"));
            AnchorPane ap = fxmlLoader.load();
            VolunteerNearController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane1);
            pane1.setCenter(ap);
        } catch (Exception e) {
            System.out.println("Bhul hoilo V near button Team controller " + e.getMessage());
        }
    }


    @FXML
    void chat(ActionEvent event) {

        try {
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Chat.LiveHandeler.class.getResource("ServerLive.fxml"));
            AnchorPane ap = fxmlLoader.load();
            // CommunityChatHandelar sadmin = fxmlLoader.getController();
            LiveHandeler sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            System.out.println("kno holo na");
        } catch (Exception e) {
            System.out.println("vul hoilo chat button Userdashboard controller " + e.getMessage());
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
            Optional<ButtonType> result=alert.showAndWait();
            if(alert.getResult().getText().equals("OK")){
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
    Pane p;


    @FXML
    void profile(ActionEvent event) {

        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(TeamProfile.TeamProfileController.class.getResource("TeamProfile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            TeamProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,pane1);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println("bhul hoilo teamdashboard button profile controller"+e.getMessage());
        }

        }



    @FXML
    void ChoiceClick(MouseEvent event) {
        if(choice.getValue().toString().equals("Logout")){
            try {

                root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("SIGN IN");
                stage.show();
                choice.getSelectionModel().select(null);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void Choiceclick(ActionEvent event) {
        if(choice.getValue().toString().equals("Logout")){
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
                Optional<ButtonType> result=alert.showAndWait();
                choice.getSelectionModel().select(null);

                if(alert.getResult().getText().equals("OK")){
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
        }else {
               try{
                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(TeamProfile.TeamProfileController.class.getResource("TeamProfile.fxml"));
                   AnchorPane ap = fxmlLoader.load();
                   TeamProfileController sadmin = fxmlLoader.getController();
                   sadmin.set(username,role,pane1);
                   pane1.setCenter(ap);
                   choice.getSelectionModel().select(null);


               }catch (Exception e){

               }
            }

    }
    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(PostBox.AddPostController.class.getResource("AddPost.fxml"));
            AnchorPane ap = fxmlLoader.load();
            AddPostController sadmin = fxmlLoader.getController();
            sadmin.set(username,role);
            pane1.setCenter(ap);


        }catch (Exception e ){
            System.out.println("ato problem ken tor, thik h. team theke post hoite problem ki");

        }

    }

    @FXML
    void Homego(MouseEvent event) {

    }
    @FXML
    private Label rolee;

    @FXML
    private ImageView search;

    @FXML
    private Label user;

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
        String []choiceb={"Profile","Logout"};
        choice.getItems().addAll(choiceb);
        File file = new File("src/main/Font/user1.png");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
        File file1 = new File("src/main/Font/1.png");
        Image image1 = new Image(file1.toURI().toString());
        ImageView i=new ImageView(image1);
        i.setFitWidth(26);
        i.setFitHeight(26);
       bbutton.setGraphic(i);
         file1 = new File("src/main/Font/logotext.png");
        Image image4 = new Image(file1.toURI().toString());
        logoimage.setImage(image4);
        file1 = new File("src/main/Font/icon1.png");
        Image image5 = new Image(file1.toURI().toString());
        imageview1.setImage(image5);
        file1 = new File("src/main/Font/search.png");
        Image image6 = new Image(file1.toURI().toString());
    /*    try {
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.HomeboardController.class.getResource("HomeBoard.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HomeboardController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane1);
            pane1.setCenter(ap);
        }catch (Exception e){

        }*/
        col_address.setStyle("-fx-text-fill: #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER-LEFT;");
        col_district.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER;");
        col_id.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold; -fx-alignment:CENTER;");
        col_title.setStyle("-fx-text-fill: #400401;-fx-border-color:transparent; -fx-padding: 10 5 10 5; -fx-font-weight: bold; -fx-alignment:CENTER-LEFT; ");
        col_type.setStyle("-fx-text-fill: #400401;-fx-alignment:CENTER; -fx-font-weighta: bold; -fx-text-size: 14;");
       // bt1.setStyle("-fx-border-color: white; -fx-background-color:  linear-gradient(from 0% 0% to 100% 100%,#ED213A  0%, #93291E  100%);");
        //loadtable();

     //   choice.setOnAction(this::ChoiceClick);

    }
    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        con=ConnectionDb.DBC();
        try {
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.HomeboardController.class.getResource("HomeBoard.fxml"));
            AnchorPane ap = fxmlLoader.load();
            HomeboardController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane1);
            pane1.setCenter(ap);
        }catch (Exception e){

        }
        alertcount();
        alertnum.setText(String.valueOf(newcount));
        Thread t=new AlertThread();
        t.start();

    }
    @FXML
    private Button alertbutton;
    @FXML
    Label  alertnum;
    @FXML
    private Button btsearch;
    int newcount=0,oldcount=0;
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
            }else{
                //System.out.println("Old= "+oldcount+" New= "+newcount);
                //alertnum.setText(newcount+"");
                oldcount=newcount;
                PauseTransition wait = new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e) -> {
                    alertnum.setText(String.valueOf(newcount));
                    wait.playFromStart();
                });
                wait.play();
            }

        }catch( Exception e ){
            System.out.println(e.getMessage());

        }

    }
    int oldct=0;
@FXML
    public void alert(ActionEvent actionEvent) {
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

    class AlertThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    //  System.out.println("hey ami choltesi");
                    Thread.sleep(5000);
                    alertcount();
                    if (newcount != oldcount) {
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




        @FXML
        void tableclick(MouseEvent event) {
            System.out.println(table.getSelectionModel().getSelectedItem().getId());
            try {
               FXMLLoader fx=new FXMLLoader();
               fx.setLocation(PostBox.Post.class.getResource("PostView.fxml"));
               AnchorPane p=fx.load();
                PostBox.Post admin=fx.getController();
                admin.set(username, role, table.getSelectionModel().getSelectedItem().getId(),pane1);
                pane1.setCenter(p);
                Connection con = ConnectionDb.DBC();
                try {
                    String sql = "SELECT * FROM notify Where username = ? and Postid = ?";
                    try {
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
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("PostBox");
                stage.show();


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

       /* @FXML
        void Vnear(ActionEvent actionEvent) {
            try {
                Shoinik.FXMLScene scene = Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
                Parent root = scene.root;
                Shoinik.VolunteerfromareaController admin = (Shoinik.VolunteerfromareaController) scene.controller;
                admin.set(username, role);
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("VolunteerfromareaController");
                stage.show();
            } catch (IOException e) {
                System.out.println("Bhul hoilo F button userdashboard controller " + e.getMessage());
            }
        }*/
    }}
