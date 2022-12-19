package AdminDB;

import AdminProfile.AdminProfileController;
import BloodBank.BloodBankController;
import DB.ConnectionDb;
import Others.TeamApproveController;
import UserProfile.ProfileController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.disaster;
import javafx.animation.PauseTransition;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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

public class AdminDashboardController implements Initializable {
   Connection con;
    @FXML
    private BorderPane pane1;
    @FXML
    Label alertnum;

  /*  @FXML
    private Button Bbankkk;

    @FXML
    private Label Logo1;*/

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


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        con=ConnectionDb.DBC();
        alertcount();
        alertnum.setText(String.valueOf(newcount));
        Thread t=new AlertThread();
        t.start();
    }

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;
    @FXML
    private TextField textfield;
    @FXML
    void searchfiled(KeyEvent e) {
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
                    // System.out.println(s2);
                    boolean i=false;
                    for(int j=0;j<s5.length;j++){
                        // System.out.println(textfield.getText().toString());
                        // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/                            if(s5[j].equalsIgnoreCase(s2)){
                            // System.out.println((s[j])+"=="+textfield.getText().toString());
                            i=true;
                        }
                    }
                    s2+=" ";
                    if(s2.equals("")){
                        i=true;
                        // System.out.println("thik ase");
                    }
                    if(s2.equals(" ")){
                        i=true;
                        //System.out.println("thik ase2");
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

    @FXML
    void BbankClick(ActionEvent event) {
        try{
            BloodBank.FXMLScene scene =  BloodBank.FXMLScene.load("BloodBank.fxml");
            Parent root = scene.root;
            BloodBankController admin= (BloodBankController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Blood Bank ");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo AdminDashboardController "+e.getMessage());
        }
    }

    @FXML
    void event(ActionEvent event) {
            try {
                Event.FXMLScene scene = Event.FXMLScene.load("ApproveEVent.fxml");
                Parent root = scene.root;
                Event.ApproveEVentController admin = (Event.ApproveEVentController) scene.controller;
                admin.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Event");
                stage.show();
            } catch (IOException e) {
                System.out.println("vul hoilo Event button Teamshboard controller " + e.getMessage());
            }


    }
    @FXML
    void Control(ActionEvent event) {

    }
    @FXML
    void TeamApprove(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("TeamApprove.fxml");
            Parent root = scene.root;
            TeamApproveController admin= (TeamApproveController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Team Approve");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo Teamaopprove AdminDashboardController"+e.getMessage());
        }
    }

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

    ObservableList<disaster> listF;
    ObservableList<disaster> getdiasterList(){
        ObservableList<disaster> diasterlist1 = FXCollections.observableArrayList();


        return diasterlist1;
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
        try{
            AdminDB.FXMLScene scene =  AdminDB.FXMLScene.load("AdminDashboard.fxml");
            Parent root = scene.root;
            AdminDashboardController admin= (AdminDashboardController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo AdminDashboardController"+e.getMessage());
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
           //hello brother how are you what happen to you. why you mod is always

    }

    @FXML
    void F(ActionEvent event) {

    }

    @FXML
    void G(ActionEvent event) {

    }

    @FXML
    void H(ActionEvent event) {

    }
    @FXML
    void vnear(ActionEvent event) {
        try{
            Shoinik.FXMLScene scene =  Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin= (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("VolunteerfromareaController");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
        }

    }


    @FXML
    void chat(ActionEvent event) {
        try {
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
            FXMLScene scene =  FXMLScene.load("AdminProfile.fxml");
            Parent root = scene.root;
            AdminProfileController admin= (AdminProfileController)scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo Admin Dashbaord profile button profile controller");
        }
       /* try {
            System.out.println("ok");

          //Pane p = FXMLScene.loadpane("Profile.fxml");
            FXMLLoader fxmlLoader = FXMLScene.loadpane("Profile.fxml");
            p=fxmlLoader.load();
            //Parent root = scene.root;
            //p = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            // p=(Pane)scene;
           // FXMLLoader fxmlLoader = (FXMLLoader) (this.p.getScene().getUserData());
            AdminDashboardController controller = (AdminDashboardController) fxmlLoader.getController();
         //  AdminDashboardController adminController = (AdminDashboardController) scene.controller;
            controller.set(username+" vai");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            pane1.setCenter(p);
            stage.show();
        }
        catch (IOException e) {
            System.out.println("error vai \n"+e);

        }*/
        /*try {
            System.out.println("ok");

            *//*FXMLScene scene = FXMLScene.load("Profile.fxml");
            Parent root = scene.root;*//*
            p = FXMLLoader.load(Dashboard.ProfileController.class.getResource("Profile.fxml"));
           // p=(Pane)scene;
            pane1.setCenter(p);
           // AdminDashboardController adminController = (AdminDashboardController) scene.controller;
           // adminController.set(username);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }
        catch (Exception e) {

        }*/




           /* try {
                // FXMLLoader o = new FXMLLoader(Profile.ProfileController.class.getResource("Profile.fxml"));
                p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));
                pane1.setCenter(p);
                stage.setTitle("Profile");
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setTitle("Profile");
                stage.show();
               // System.out.println("helloApplication");
            } catch (Exception e) {

            }*/
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
                  /* root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.setTitle("SIGN IN");
                   stage.show();*/
                   UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
                   Parent root = scene.root;
                   ProfileController adminController = (ProfileController) scene.controller;
                   adminController.set(username,role);
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(new Scene(root));
                   stage.setTitle("Profile");
                   stage.show();

               }catch (Exception e){

               }
               /* try {
                    //  FxmlLoader o = new FxmlLoader();
                    p = FXMLLoader.load(Profile.ProfileController.class.getResource("Profile.fxml"));

                    pane1.setCenter(p);
                    stage.setTitle("Profile");
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                    stage.setTitle("Profile");
                    stage.show();
                    System.out.println("helloApplication");
                } catch (Exception e) {

                }*/
            }

    }
    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            PostBox.FXMLScene scene =  PostBox.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();

          /*  root = FXMLLoader.load(AddPostController.class.getResource("AddPost.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIGN IN");
            stage.show();*/

        }catch (Exception e ){

        }

    }

    @FXML
    void Homego(MouseEvent event) {

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
                for (int j = 0; j < s5.length; j++) {
                    // System.out.println(textfield.getText().toString());
                    // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/
                    if (s5[j].equalsIgnoreCase(s2)) {
                        // System.out.println((s[j])+"=="+textfield.getText().toString());
                        i = true;
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
    @FXML
    private Label rolee;

    @FXML
    private ImageView search;

    @FXML
    private Label user;
    @FXML
    private Button alertbutton;
    @FXML
    private Button btsearch;
    int oldcount=0,newcount=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView0 = new ImageView(new Image(new File("src/main/Font/notify.png").toURI().toString()));
        imageView0.setFitHeight(20);
        imageView0.setFitWidth(25);
        alertbutton.setGraphic(imageView0);
        ImageView imageView1= new ImageView(new Image(new File("src/main/Font/search.png").toURI().toString()));
        imageView1.setFitHeight(20);
        imageView1.setFitWidth(25);
        btsearch.setGraphic(imageView1);
        String []choiceb={"Profile","Logout"};
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
        //search.setImage(image6);
       loadtable();
     //   choice.setOnAction(this::ChoiceClick);

    }

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
        class AlertThread extends Thread{
            @Override
            public void run() {
                while (true) {
                    try {
                        //  System.out.println("hey ami choltesi");
                        Thread.sleep(5000);
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
        void alert(ActionEvent e){
        System.out.println("vai amare marse");

    }
        @FXML
        void tableclick(MouseEvent event)
        {
            System.out.println(table.getSelectionModel().getSelectedItem().getId());
            try{
                PostBox.FXMLScene scene =  PostBox.FXMLScene.load("PostView.fxml");
                Parent root = scene.root;
                PostBox.Post admin= (PostBox.Post) scene.controller;
                admin.set(username,role,table.getSelectionModel().getSelectedItem().getId());
                Connection con=ConnectionDb.DBC();
                try{
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
                            ps1.setInt(2,table.getSelectionModel().getSelectedItem().getId());
                            ps1.execute();
                            ps1.close();
                            //rs1.close();
                        } else {;
                            System.out.println("ase aita");
                        }
                        resultSet.close();
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }

                }catch( Exception e ){
                    System.out.println(e.getMessage());

                }
                stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("PostBox");
                stage.show();


            }catch (Exception e ){
                System.out.println(e.getMessage());
            }


        }
}
