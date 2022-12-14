package UserProfile;
import AdminDB.*;
import Chat.ChatPrivateController;
import DB.ConnectionDb;
import Post.AddPostController;
import Sign_in.SigninController;
import com.example.sheccashoinik.Application;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;


public class ProfileController implements Initializable {
    @FXML
    private BorderPane pane1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role1="";
    @FXML
    private Button pfield;
    private String user2;
    private String name2;

    public void set(String username,String role,String name2, String user2) {
        this.role1 = role;
        this.username = username;
        this.user2 = user2;
        this.name2 = name2;
    }
@FXML
void paction(ActionEvent event){
    try {
        if (pfield.getText().equals("Chat")) {
            Chat.FXMLScene scene = Chat.FXMLScene.load("ChatPrivate.fxml");
            Parent root = scene.root;
            ChatPrivateController adminController = (ChatPrivateController) scene.controller;
            adminController.set(username,role1,name2,user2);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();
        } else {

        }
    }catch(Exception e){
        System.out.println("paction profile controller "+e.getMessage());
    }

}

  /*  @FXML
    private Button Bbank;

    @FXML
    private Label Logo1;*/

    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private ImageView userimage;
    @FXML
    private ImageView imageview;
    @FXML
    private ImageView bimage;
    @FXML
    void BbankClick(ActionEvent event) {

    }
    @FXML
    private Button b;

    @FXML
    private Button bbutton;

    /* @FXML
     private ChoiceBox<?> choice;

     @FXML
     private ImageView imageview;
 */


    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    void BbankClick(MouseEvent event) {

    }
    @FXML
    private ScrollPane spane;
    Connection con;
    public ProfileController() {
        con = ConnectionDb.DBC();
        // System.out.println("thik ase vai koibar bolboo");
    }



    @FXML
    void Dashboard(ActionEvent event) {
        try {
            if (role1.equals("User")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            }else if (role1.equals("Admin")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
               /* AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard1.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("AdminDashboard");
                stage.show();*/
            }else{
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
           /* AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard1.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role1);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("TeamDashboard");
                stage.show();*/
            }
        }catch(IOException e){
            System.out.println("vul hoilo Profile controller dashboard "+e.getMessage());
        }


        System.out.println("vaiya ki khobor "+username);

    }

    @FXML
    void Diaster(ActionEvent event) throws IOException {

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
    void Vnear(ActionEvent event) {

    }


    @FXML
    void chat(ActionEvent event) {

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
        try {
            UserProfile.FXMLScene scene = UserProfile.FXMLScene.load("Profile.fxml");
            Parent root = scene.root;
            ProfileController admin = (ProfileController) scene.controller;
            admin.set(username, role1);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
        } catch (Exception e) {
            System.out.println("vul hoilo profile controller ");
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
                UserProfile.ProfileController adminController = (UserProfile.ProfileController) scene.controller;
                adminController.set(username,role1);
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
    void ChoiceClick(ActionEvent event){

    }
    @FXML
    void addpost(ActionEvent event) {
        System.out.println("hello");
        try{
            Post.FXMLScene scene =  Post.FXMLScene.load("AddPost.fxml");
            Parent root = scene.root;
            AddPostController admin= (AddPostController) scene.controller;
            admin.set(username,role1);
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
    private Label rolee;

    @FXML
    private Label user;


    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.username = username;
        this.role1 = role;
        output();
      // System.out.println("on set "+username);
    }


    @FXML
    private Label BG;

    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label NID;

    @FXML
    private Label Name;

    @FXML
    private Label Phone;
    @FXML
    private Label field;
    @FXML
    public Label showuser;
    public String uname;
    public void output(){
        try{
            Statement stmt=con.createStatement();
             String sql = "SELECT Name,Username,Phone,ID,Division,District,Volunteer,BG FROM userlist Where Username = \'"+user.getText()+"\'";
            //String sql = "SELECT * FROM `userlist` Where Username = '"+1+"'";
            //System.out.println("'"+user.getText()+"'");
            //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
            //String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                Phone.setText(rs.getString(3));
                NID.setText(rs.getString(4));
                District.setText(rs.getString(6));
                Division.setText(rs.getString(5));
                field.setText(rs.getString(7));
                BG.setText(rs.getString(8));


            }
            rs.close();
            stmt.close();
            con.close();
            uname=showuser.getText().toString();
           /* System.out.println(uname);
            System.out.println(username);*/
            //System.out.println(user.getText().toString());
            if(user.getText().toString().equals(uname)) {
               // pfield.setText("Edit"); //pore add korbo
            }else{

            }
            showuser.setText("@"+showuser.getText().toString());
        } catch (SQLException ex) {
            System.out.println("onk error");
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
     /*   username= Application.oname;*/


        //System.out.println(username);
      //  output();
       /* try{
        Statement stmt=con.createStatement();
       // String sql = "SELECT Name,Username,Phone,ID,Division,District,Volunteer,BG FROM userlist Where Username = \'"+username+"\'";
       String sql = "SELECT * FROM `userlist` Where Username = "+username+"";
            System.out.println("'"+username+"'");
            //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
        //String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
                Name.setText(rs.getString(1));
                showuser.setText(rs.getString(2));
                Phone.setText(rs.getString(3));
                NID.setText(rs.getString(4));
                District.setText(rs.getString(6));
                Division.setText(rs.getString(5));
                field.setText(rs.getString(7));
                BG.setText(rs.getString(8));

            }
            rs.close();
            stmt.close();
            con.close();


        } catch (SQLException ex) {
            System.out.println("onk error");
            System.err.println(ex.getMessage());
        }
*/

    }
}