package Chat;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Others.TaskCompletedController;
import Post.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class CommunityChatHandelar implements Initializable {
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
        connect();
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
    private TableColumn<userlist, String> colname;

    @FXML
    private TableColumn<userlist, String> coluser;

    @FXML
    void tableclick(MouseEvent event) {
        String Name2=usertable.getSelectionModel().getSelectedItem().getName().toString();
        String user2=usertable.getSelectionModel().getSelectedItem().getUsername().toString();
        try{
                  /* root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.setTitle("SIGN IN");
                   stage.show();*/
            Chat.FXMLScene scene =  Chat.FXMLScene.load("ChatPrivate.fxml");
            Parent root = scene.root;
            Chat.ChatPrivateController adminController = (Chat.ChatPrivateController) scene.controller;
            adminController.set(username,role,Name2,user2);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chat");
            stage.show();

        }catch (Exception e){

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


    }
    @FXML
    void BbankxClick(ActionEvent event) {

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
    void F(ActionEvent event) {

    }@FXML
    void send1(ActionEvent event) {

    }
    @FXML
    void H(ActionEvent event) {

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
    String []name;
    @FXML
    Button button;
    @FXML
    public  TextArea showArea;
    @FXML
   public  TextField inputField;
    boolean isConnected = false;
    BufferedReader reader;
    String inputName=username;
    BufferedWriter writer;
    Socket sc;
    public CommunityChatHandelar(){
        name= new String[]{"sabbir","shahin"};
    }
    void connect() {
        try {
            sc = new Socket("localhost", 1100);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            writer.write(username + "\n");
            writer.flush();
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            Thread serverListener = new WriteThread(showArea,reader);
            serverListener.start();
            //showArea.appendText("Connection established!\n");
            BufferedReader in = null;
            File file = new File("msg.txt");
            try {
                in = new BufferedReader(new FileReader(file));
                String str;
                while ((str = in.readLine()) != null) {
                    showArea.appendText(str + "\n");
                }
            } catch (IOException ie) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            //button.setText("Send");
            //inputField.setPromptText("Write your message.");
            isConnected = true;
        } catch (IOException ie) {
                System.out.println("net pai na");
                ie.printStackTrace();
            }catch(Exception ie0){
                System.out.println("onek vul abr net pai na");

            }

    }
    @FXML
    void send(ActionEvent e){
       /* if(!isConnected) {
            // Client is not connected with the server, lets connect with server
           *//* inputName = inputField.getText();
            inputField.clear();*//*
           // int i=1;
           *//* for(String n : name){
                if(n.equals(inputName))i=1;

            }*//*
          *//*  if(inputName == null || inputName.length() == 0){
                showArea.appendText("Enter a valid name!\n");
                return;
            }*//*

            try {
                Socket sc = new Socket("localhost", 1100);
                OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
                writer = new BufferedWriter(o);
                writer.write(username+"\n");
                writer.flush();
                InputStreamReader isr = new InputStreamReader(sc.getInputStream());
                reader = new BufferedReader(isr);
                String name11 = "sabbir";
                String name12 = "shahin";
                //Anonymous inner class
                Thread serverListener = new Thread(){
                    @Override
                    public void run() {
                        while(true){

                            try {
                                System.out.println("likhtesi");
                                String data = reader.readLine() + "\n";
                                showArea.appendText(data);
                              //  reader.
                            }
                            catch (SocketException e){

                                showArea.appendText("Connection lost!\n");
                                break;
                            }
                            catch (IOException e) {
                                System.out.println("hoi na kn "+e.getMessage());

                            }catch(Exception e) {
                                System.out.println("ki plbm "+e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }
                };

                serverListener.start();
                showArea.appendText("Connection established!\n");
                Alert a = new Alert(Alert.AlertType.NONE);
                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {

                        a.setAlertType(Alert.AlertType.CONFIRMATION);
                        a.show();
                    }
                };

                BufferedReader in = null;
                File file = new File("msg.txt");
                try {
                    in = new BufferedReader(new FileReader(file));
                    String str;
                    while ((str = in.readLine()) != null) {
                        showArea.appendText(str+ "\n");
                    }
                } catch (IOException ie) {
                } finally {
                    try { in.close(); } catch (Exception ex) { }
                }
                //button.setText("Send");
                //inputField.setPromptText("Write your message.");
                isConnected = true;
            } catch (IOException ie) {
                System.out.println("net pai na");
                ie.printStackTrace();
            }catch(Exception ie0){
                System.out.println("one vul abr net pai na");

            }
        }
        else{*/
            try {
                OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
                writer = new BufferedWriter(o);
                String msg = inputField.getText();
                inputField.clear();
                if (msg == null || msg.length() == 0) {
                    System.out.println("msg likh");
                    return;
                }
                System.out.println("msg gese");
                File file = new File("msg.txt");
                FileWriter w = new FileWriter(file,true);
                w.write(username+": "+msg+ "\n");
                writer.write(msg + "\n");
                 writer.flush();
                 //writer.close();
                //showArea.appendText(username+": "+msg+ "\n");
                w.close();
            }
            catch (IOException ie){
                ie.printStackTrace();
            }
        }
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        loadtable();

        //search.setImage(image6);
        //Chat.MyServer.server();
       // connect();
    }

    public void VolunteerNear(ActionEvent actionEvent) {

    }

    public void BbankClick(MouseEvent mouseEvent) {
    }

}

