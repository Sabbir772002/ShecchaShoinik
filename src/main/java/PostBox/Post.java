package PostBox;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Sign_in.SigninController;
import PostBox.MapController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

public class Post {
    public Post() throws FileNotFoundException {
        con = ConnectionDb.DBC();
    }

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username = "";
    public String role = "";
    int id;
    Connection con;
    @FXML
    private Label addinfo;

    @FXML
    private Label address;

    @FXML
    private Button delete;

    @FXML
    private Button bbutton;

    @FXML
    private ImageView bimage;

    @FXML
    private Button bt1;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private Label district;

    @FXML
    private Label division;

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
    String post[] = new String[6];
    File file = new File("im.png");
    FileOutputStream fos = new FileOutputStream(file);
    byte pic[];
    Blob blob;
    disaster dlist = null;
    public void set(String username, String role, int id) {
        if(role.equals("Admin"))delete.setVisible(true);
       // System.out.println("i am in set");
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.id = id;
        loadbox();
        title.setText(dlist.getTitle());
        type.setText(dlist.getType());
        address.setText(dlist.getAddress());
        division.setText(dlist.Division);
        district.setText(dlist.District);
        addinfo.setText(dlist.getAddInfo());
        poster.setImage(new Image(file.toURI().toString()));
    }  public void set(String username, String role, int id, BorderPane pane) {
        if(role.equals("Admin"))delete.setVisible(true);

       // System.out.println("i am in set");
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.id = id;
        loadbox();
        title.setText(dlist.getTitle());
        type.setText(dlist.getType());
        address.setText(dlist.getAddress());
        division.setText(dlist.Division);
        district.setText(dlist.District);
        addinfo.setText(dlist.getAddInfo());
        poster.setImage(new Image(file.toURI().toString()));
        this.pane1=pane;
    }

    void loadbox() {
        //System.out.println("i am in load");
        String sql = "SELECT Title,Type,Address,Division,District,AddInfo,Image from diasterlist where Id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            /*  preparedStatement.setString(2, passw);*/
            ResultSet rs = preparedStatement.executeQuery();
            int i = 0;
            int j = 1;
            while (rs.next()) {
                System.out.println("thik ase");
                //String Title,Type, Address, Division, District, Id,AddInfo
                dlist = new disaster((rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), id, rs.getString(6));

                // if(rs.next()){
                blob = rs.getBlob(7);
                pic = blob.getBytes(1, (int) blob.length());
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
            System.out.println("plbm in sql" + e.getMessage());
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

    @FXML
    void Delete(ActionEvent e) {

    }
    @FXML
    void viewmap(ActionEvent e) {
        //System.out.println("ashlam kaj holo na1");
        try {
            //System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(PostBox.MapController.class.getResource("MapView.fxml"));
            AnchorPane ap = fxmlLoader.load();
             PostBox.MapController sadmin = fxmlLoader.getController();
            sadmin.set(username, role,id);
            pane1.setCenter(ap);
            System.out.println("kno holo na");

        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }
}


/*
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
        import javafx.stage.Stage;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.*;
        import java.util.Optional;
        import java.util.ResourceBundle;

public class MapController implements Initializable {
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

    public void set(String username,String role,int id) {
        System.out.println("i am in set");
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.id=id;
        loadbox();
        // title.setText(dlist.getTitle());
        // type.setText(dlist.getType());
        address.setText(dlist.getAddress());
        district=dlist.District;
        // division.setText(dlist.Division);
        // district.setText(dlist.District);
        //addinfo.setText(dlist.getAddInfo());
        // poster.setImage(new Image(file.toURI().toString()));
    }

    void loadbox(){
        //System.out.println("i am in load");
        String sql = "SELECT Title,Type,Address,Division,District,AddInfo,Image from diasterlist where Id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            */
/*  preparedStatement.setString(2, passw);*//*

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
        */
/*user.setText(username);
        rolee.setText(role);*//*

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
}
*/
