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

public class MapController implements Initializable {
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
        loadbox();
       title.setText(dlist.getTitle());
        //type.setText(dlist.getType());
         address.setText(dlist.getAddress());
         district=dlist.getDistrict();
        //district.setText(dlist.District);
        //addinfo.setText(dlist.getAddInfo());
    /*    try {

           // poster.setImage(new Image(file.toURI().toString()));
            FileReader f1 = new FileReader(new File("src/main/resources/Map/map2.html"));
            File f0=new File("src/main/resources/Map/map3.html");
            FileWriter f = new FileWriter(f0);
            BufferedWriter bw = new BufferedWriter(f);
            BufferedReader bf = new BufferedReader(f1);
            String s = "";
            while ((s = bf.readLine()) != null) {
                if (s.equals("Sabbir")) {
                    s = address.getText().toString();
                    System.out.println("s add hoi nai");
                }
                System.out.println(district);
                s = s.replace("ullapara", district);
                bw.write(s);
                bw.write("\n");


            }
            bf.close();
            bw.close();
            f.close();
            f1.close();
            File f9=new File("src/main/resources/Map/map3.html");
            FileInputStream fis=new FileInputStream(f9);
            FileReader f00=new FileReader(f9);
            con=ConnectionDb.DBC();
            String st = "Update map set File=? where ID=1";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
           // preparedStatement.setString(1,"Map3");
            preparedStatement.setBinaryStream(1,fis,(int)f9.length());

            preparedStatement.execute();
            System.out.println("hoye gelo");
            preparedStatement.close();
            con.close();
          *//*  File file = new File("map4.html");
            FileOutputStream fos = new FileOutputStream(file);
            byte b[];
            String s0="";
              con= ConnectionDb.DBC();
            PreparedStatement ps = con.prepareStatement("select File where Where ID=1");
            ResultSet rs = ps.executeQuery();*//*
            con= ConnectionDb.DBC();
            File file = new File("src/main/resources/Map/map5.html");
            FileOutputStream fos = new FileOutputStream(file);
            byte b[];


            PreparedStatement ps = con.prepareStatement("select File from map where ID=1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                blob = rs.getBlob("File");
                b = blob.getBytes(1, (int) blob.length());
                fos.write(b);
            }
            //System.out.println("Imgae Rerived successfully to " + file.getPath() + "  path");
            ps.close();
            con.close();
           *//* while (rs.next()) {

              *//**//*  Clob clob = rs.getClob("File");
                Reader reader = clob.getCharacterStream();
                System.out.println("hello");
                //String filePath = "E:\Data\clob_output"+j+".txt";
                FileWriter writer = new FileWriter(file);
                int i;
                while ((i = reader.read())!=-1) {
                    writer.write(i);
                }
                writer.close();*//**//*
            }
            rs.close();
            ps.close();*//*
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
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

    void loadbox(){
        //System.out.println("i am in load");
        String sql = "SELECT Title,Type,Address,Division,District,AddInfo,Image from diasterlist where Id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            /*  preparedStatement.setString(2, passw);*/
            ResultSet rs = preparedStatement.executeQuery();
            int i = 0;
            int j=1;
            while(rs.next()){
                System.out.println("thik ase");
                //String Title,Type, Address, Division, District, Id,AddInfo
                dlist=new disaster((rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), id, rs.getString(6));

                // if(rs.next()){
               /* blob=rs.getBlob(7);
                pic=blob.getBytes(1,(int)blob.length());
                fos.write(pic);*/
                // }

            }
            rs.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("plbm in sql"+e.getMessage());
        }
    }



    @FXML
    void Dashboard(ActionEvent event) {
        try {
            if (role.equals("User")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            }else if(role.equals("Admin")){
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();

            }else{
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();
            }
        }catch(IOException e){
            System.out.println("vul hoilo add post er dashboard "+e.getMessage());
        }
    }


    @FXML
    void BbankClick(MouseEvent event) {

    }

    @FXML
    void ChoiceClick(MouseEvent event) {

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
            try {

                UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("Profile.fxml");
                Parent root = scene.root;
                ProfileController adminController = (ProfileController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Profile");
                stage.show();

            } catch (Exception e) {

            }
        }
    }
    @FXML
    void Diaster(ActionEvent event) {

    }

    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            PostBox.FXMLScene scene =  PostBox.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            PostBox.AddPostController admin= (PostBox.AddPostController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Diaster");
            stage.show();


        }catch (Exception e ){

        }
    }

    @FXML
    void chat(ActionEvent event) {
        try{
            Chat.FXMLScene scene =Chat.FXMLScene.load("CommunityChat.fxml");
            Parent root = scene.root;
            //System.out.println("chat cole na");
            Chat.CommunityChatHandelar admin= (Chat.CommunityChatHandelar) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo chat button Userdashboard controller "+e.getMessage());
        }

    }

    @FXML
    void hresponse(ActionEvent event) {

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

    @FXML
    void profile(ActionEvent event) {
        try{
            UserProfile.FXMLScene scene =  UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin= (ProfileController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo profile button Userdashboard controller "+e.getMessage());
        }

    }


    @FXML
    void task(ActionEvent event) {

    }

    @FXML
    void vapprove(ActionEvent event) {
        try{
            Shoinik.FXMLScene scene =  Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin= (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Volunteer Near Me");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
        }

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
            stage.setTitle("Volunteer Near Me");
            stage.show();
        }catch(IOException e){
            System.out.println("vul hoilo F button userdashboard controller "+e.getMessage());
        }

    }
    void imageload() {
        try {

            File file = new File("D:\\im.png");
            FileOutputStream fos = new FileOutputStream(file);
            byte b[];
            Blob blob;

            PreparedStatement ps = con.prepareStatement("select * from pp where ID=0");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                blob = rs.getBlob("image");
                b = blob.getBytes(1, (int) blob.length());
                fos.write(b);
            }
            System.out.println("Imgae Rerived successfully to " + file.getPath() + "  path");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("sql error at post");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         WebEngine engine = view.getEngine();
        //engine.load(String.valueOf(getClass().getResource("map3.html")));
        /*user.setText(username);
        rolee.setText(role);*/
        String []choiceb={"Profile","Logout"};
        //  choice.getItems().addAll(choiceb);
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
