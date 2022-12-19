package TeamPostBox;

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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private WebView view;
    WebEngine engine = view.getEngine();

    public MapController() throws FileNotFoundException {
        con= ConnectionDb.DBC();
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
    int id;
    Connection con;
    String addinfo;

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

    @FXML
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
    private ImageView poster;

    @FXML
    private Label rolee;

    @FXML
    private Text title;

    @FXML
    private Label type;

    @FXML
    private Label user;
    String post[]=new String[6];
    File file=new File("im.png");
    FileOutputStream fos=new FileOutputStream(file);
    byte pic[];
    Blob blob;
    disaster dlist = null;

    public void set(String username,String role,int id) throws IOException {
        System.out.println("i am in map set");
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.id=id;
        loadbox();
       // title.setText(dlist.getTitle());
       // type.setText(dlist.getType());
        address.setText(dlist.getAddress());

       // division.setText(dlist.Division);
        district=dlist.District;
        //addinfo.setText(dlist.getAddInfo());
        //poster.setImage(new Image(file.toURI().toString()));
        FileReader f1=new FileReader(new File("src/main/resources/Map/map2.html"));
        FileWriter f=new FileWriter(new File("src/main/resources/Map/mapsbd.html"));
        BufferedWriter bw=new BufferedWriter(f);
        BufferedReader bf= new BufferedReader(f1);
        String s="";
        while((s =bf.readLine()) != null){
            if(s.equals("Sabbir")){
                s=address.getText().toString();
                System.out.println("s add hoi nai");
            }
            System.out.println(district);
            s=s.replace("ullapara",district);
            bw.write(s);
            bw.write("\n");

        }
        bf.close();
        bw.close();
        f.close();
        f1.close();
        engine.load(String.valueOf(getClass().getResource("mapsbd.html")));


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
                blob=rs.getBlob(7);
                pic=blob.getBytes(1,(int)blob.length());
                fos.write(pic);
                // }

            }
            rs.close();
            fos.close();
            // System.out.println(dlist.AddInfo+" "+dlist.Address);
              /*if(resultSet.next()) {
                  post[0] = resultSet.getString(1);
                  System.out.println(post[1]);
              } if(resultSet.next()) {
                  post[1] = resultSet.getString(2);
                  System.out.println(post[2]);
              } if(resultSet.next()) {
                  post[2] = resultSet.getString(3);
              } if(resultSet.next()) {
                  post[3] = resultSet.getString(4);
              } if(resultSet.next()) {
                  post[4] = resultSet.getString(5);
              } if(resultSet.next()) {
                  post[5] = resultSet.getString(7);
              }*/
                /*  System.out.println(i+" bar");
                  if(j==6){j=7;}
                  post[i]= resultSet.getString(j);
                  System.out.println(post[i]);*/
            //System.out.println(resultSet.getString(1));
                 /* post[0] = resultSet.getString(1);
                  System.out.println(post[0]);
                  post[1] = resultSet.getString(2);
                  post[2] = resultSet.getString(3);
                  post[3] = resultSet.getString(4);
                  post[4] = resultSet.getString(5);
                  post[5] = resultSet.getString(7);*/
                   /*  blob=resultSet.getBlob(8);
                     pic=blob.getBytes(1,(int)blob.length());
                      fos.write(pic);*/

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
            FXMLScene scene =  FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
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
    void viewmap(ActionEvent event) {

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
        //WebEngine engine = view.getEngine();
      /*  try {
            loadweb();
        }catch(Exception e){

        }
        //  engine.load(String.valueOf(getClass().getResource("https://www.google.com/maps/place/%E0%A6%A2%E0%A6%BE%E0%A6%95%E0%A6%BE/@23.7805733,90.2791955,11z/data=!3m1!4b1!4m5!3m4!1s0x3755b8b087026b81:0x8fa563bbdd5904c2!8m2!3d23.810332!4d90.4125181")));
        engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
*/
    }
void loadweb()throws Exception {

    FileReader f1=new FileReader(new File("src/main/resources/Map/map2.html"));
    FileWriter f=new FileWriter(new File("src/main/resources/Map/mapsbd.html"));
    BufferedWriter bw=new BufferedWriter(f);
    BufferedReader bf= new BufferedReader(f1);
    String s="";
    while((s =bf.readLine()) != null){
        if(s.equals("Sabbir")){
            s=address.getText().toString();
            System.out.println("s add hoi nai");
        }
        System.out.println(district);
        s=s.replace("ullapara",district);
        bw.write(s);
        bw.write("\n");


    }
    bf.close();
    bw.close();
    f.close();
    f1.close();
}
@FXML
void gomap(ActionEvent event){

        engine.load(String.valueOf(getClass().getResource("mapsbd.html")));
    }


}
