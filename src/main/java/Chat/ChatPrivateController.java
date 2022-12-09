package Chat;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Others.TaskCompletedController;
import Post.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.diaster;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

import static java.lang.Thread.sleep;

public class ChatPrivateController implements Initializable {
    Connection con;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String user2="";
    public String name2="";
    public String role="";

    @FXML
    public TextField writebox;
    @FXML
    public Label Name2;
    @FXML
    public TextArea msgbox;
    public void set(String username,String role) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        refresh();
//        if(username.equals("Sabbir")){
//            user2="Nuha";
//        }else{
//            user2="Sabbir";
//        }
        //loadtable();
    }
    public void set(String username,String role,String name2, String user2) {
        user.setText(username);
        rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        this.user2 = user2;
        this.name2 = name2;
        Name2.setText(name2);
        refresh();
        /*Thread chatwriter = new PrivateThread(msgbox,username,user2);
        chatwriter.start();*/

    }

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

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView logoimage;

    @FXML
    private Label rolee;


    @FXML
    private Label user;
    @FXML
    private ChoiceBox<String> choice1;

    @FXML
    private TableColumn<userlist, String> colname;

    @FXML
    private TableColumn<userlist, String> coluser;

    @FXML
    void tableclick(MouseEvent event) {
       /* String Name2=usertable.getSelectionModel().getSelectedItem().getName().toString();
        String user2=usertable.getSelectionModel().getSelectedItem().getUsername().toString();*/
        try{

            String Name2=usertable.getSelectionModel().getSelectedItem().getName().toString();
            String user2=usertable.getSelectionModel().getSelectedItem().getUsername().toString();
            Chat.FXMLScene scene =  Chat.FXMLScene.load("ChatPrivate.fxml");
            Parent root = scene.root;
            Chat.ChatPrivateController adminController = (Chat.ChatPrivateController) scene.controller;
            adminController.set(username,role,Name2,user2);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();

        }catch (Exception e){
            System.out.println("error on tabble click "+e.getMessage());
        }

    }
    @FXML
    private TableView<userlist> usertable;

    ObservableList<userlist> listF;
    ObservableList<userlist> getdiasterList(){
        ObservableList<userlist> userlist1 = FXCollections.observableArrayList();


        return userlist1;
    }
    int indexM = -1;

    void loadtable(){
        colname.setCellValueFactory(new PropertyValueFactory<userlist,String>("Name"));
        coluser.setCellValueFactory(new PropertyValueFactory<userlist,String>("Username"));
        //table.setItems(list);
        listF = ConnectionDb.getuserlist();
        usertable.setItems(listF);
        refresh();

    }

    @FXML
    void BbankxClick(ActionEvent event) {

    }

    @FXML
    void ChoiceClick(MouseEvent event) {

    }  @FXML
    void F(MouseEvent event) {

    }  @FXML
    void G(MouseEvent event) {

    }
@FXML
    void H(MouseEvent event) {

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
                stage.setTitle("User Home");
                stage.show();
            }else if(role.equals("Admin")){
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Admin Home");
                stage.show();

            }else {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(username, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Team Home");
                stage.show();
            }
        }catch(IOException e){
            System.out.println("vul hoilo add post er dashboard "+e.getMessage());
        }

    }

    @FXML
    void Diaster(ActionEvent event) {

    }

    @FXML
    void Hresponse(ActionEvent event) {

    }

    @FXML
    void G(ActionEvent event) {

    }

    @FXML
    void task(ActionEvent event) {
        try{
            Others.FXMLScene scene =  Others.FXMLScene.load("TaskCompleted.fxml");
            Parent root = scene.root;
            TaskCompletedController admin= (TaskCompletedController) scene.controller;
            admin.set(username,role);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Task Completed");
            stage.show();
        }catch (Exception e){
            System.out.println("vul hoilo team dashbaord button G controller "+e.getMessage());
        }

    }

    @FXML
    void addpost(ActionEvent event) {
        try{
            Post.FXMLScene scene =  Post.FXMLScene.load("AddPost.fxml");
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
            System.out.println("vul hoilo add post controller");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadtable();
        //refresh();
        String []choice1={"Profile","Logout"};
        choice.getItems().addAll(choice1);
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
        msgbox.appendText(" ");
        rolee.setText(role);
        user.setText(username);
        //Thread t=new chatthread();
        //t.start();
       // refresh();
    }

    public void vnear(ActionEvent actionEvent) {

        try {
            Shoinik.FXMLScene scene = Shoinik.FXMLScene.load("Volunteerfromarea.fxml");
            Parent root = scene.root;
            Shoinik.VolunteerfromareaController admin = (Shoinik.VolunteerfromareaController) scene.controller;
            admin.set(username, role);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Volunteer Near Me");
            stage.show();
        } catch (IOException e) {
            System.out.println("vul hoilo vnear button chatprivate controller " + e.getMessage());
        }
    }


    public void BbankClick(MouseEvent mouseEvent) {

    }

    public ChatPrivateController(){

        con = ConnectionDb.DBC();
       // loadtable();

        // refresh();

    }
 /*   class chatthread extends Thread {

        public void run() {
           // con=ConnectionDb.DBC();

            while (true) {
                try {
                    msgbox.clear();
                   //refresh();
                   sleep(1000);
                } catch (Exception ex) {
                    System.out.println("eto vul kno");
                    System.out.println(ex.getMessage());

                }
            }
        }
    }*/
    @FXML
    void refresh(ActionEvent e){
        msgbox.clear();
        try {
            con=ConnectionDb.DBC();
            String sql = "SELECT * FROM privatechat Where Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?";
/*
            OR Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?
*/
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username + user2);
            preparedStatement.setString(2, user2 + username);
            preparedStatement.setString(3, user2 + username);
            preparedStatement.setString(4, username+user2);
         /*   preparedStatement.setString(5, username + "Nuha");
            preparedStatement.setString(6, "Nuha" + username);
            preparedStatement.setString(7, "Sabbir" + username);
            preparedStatement.setString(8, username+"Sabbir");*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                msgbox.appendText(resultSet.getString(3));
                msgbox.appendText("\n");
            }
            //sleep(1000);
            resultSet.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("sudu vul");
            System.out.println(ex.getMessage());

        }
    }
    void refresh(){
        msgbox.clear();
        try {
            con=ConnectionDb.DBC();
            String sql = "SELECT * FROM privatechat Where Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?";
/*
            OR Sender = ? OR Sender = ? OR Reciver = ? OR Reciver = ?
*/
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username + user2);
            preparedStatement.setString(2, user2 + username);
            preparedStatement.setString(3, user2 + username);
            preparedStatement.setString(4, username+user2);
         /*   preparedStatement.setString(5, username + "Nuha");
            preparedStatement.setString(6, "Nuha" + username);
            preparedStatement.setString(7, "Sabbir" + username);
            preparedStatement.setString(8, username+"Sabbir");*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                msgbox.appendText(resultSet.getString(3));
                msgbox.appendText("\n");
            }
            //sleep(1000);
            resultSet.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("sudu vul");
            System.out.println(ex.getMessage());

        }
    }


    @FXML
    public void send(ActionEvent e) {
       // msgbox.clear();
       // refresh();
        try {
            con=ConnectionDb.DBC();
        String st = "INSERT INTO privatechat (Sender, Reciver, Msg) VALUES (?,?,?)";
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
        if(username.equals("Sabbir")){
            preparedStatement.setString(1,  username+user2);
            preparedStatement.setString(2, user2+username);
        }else{
            preparedStatement.setString(1,  username+user2);
            preparedStatement.setString(2, user2+username);
        }
        preparedStatement.setString(3, username+" : "+writebox.getText());
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
        msgbox.appendText(username+" : "+writebox.getText());
        msgbox.appendText("\n");
        writebox.setText("");


    }catch (Exception ie){

            System.out.println("from send privatechat "+ie.getMessage());
    }
}
    }
