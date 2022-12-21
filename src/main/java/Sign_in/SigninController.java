package Sign_in;

import AdminDB.*;
import AdminDB.FXMLScene;
import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class SigninController implements Initializable {
    Connection con;
    public SigninController() {
        con = ConnectionDb.DBC();
       // System.out.println("thik ase vai koibar bolboo");
    }
    @FXML
    private ComboBox<String> sign_in_box;
    @FXML
    private ImageView user;
    @FXML
    private ImageView pass;
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label passl;

    @FXML
    private Label userl;
    @FXML
    private Label selectl;

    private Stage stage;

    private Scene scene;
     Parent root;
    String usern="";
    String role="";
    public void set(String role){
        this.usern=role;
    }
    AdminDashboardController ad=new AdminDashboardController();



    @FXML
    void sign_in(ActionEvent event) {
   Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (logIn().compareTo("Success")==0) {
                try  {
                    role=sign_in_box.getValue().toString();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Login Successfully!");
                alert.setHeaderText("Login Successfully!");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                //alert.initOwner(stage);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result=alert.showAndWait();
                if(alert.getResult().getText().compareTo("OK")==0){
                    if(role.equals("User")) {
                        AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("UserDashboard.fxml");
                        //FXMLScene scene = FXMLScene.load("BackgroundDesign.fxml");
                        Parent root = scene.root;
                        UserDashboardController adminController = (UserDashboardController) scene.controller;
                        //Back adminController = (Back) scene.controller;
                        adminController.set(usern, role);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("UserProfile");
                        stage.show();
                    }else if(role.equals("Admin")){
                        AdminDB.FXMLScene scene =AdminDB.FXMLScene.load("AdminDashboard.fxml");
                        Parent root = scene.root;
                        AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                        adminController.set(usern, role);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Admin Dashboard");
                        stage.show();
                    }else{
                        AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard.fxml");
                        Parent root = scene.root;
                        TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                        adminController.set(usern, role);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Team Home");
                        stage.show();
                    }
                }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(logIn().compareTo("Error")==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Sign in Error!");
                alert.setHeaderText("Please input correct info or Sign Up");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                alert.initOwner(stage1);
                //alert.setGraphic(new ImageView(image));
                //user.setImage(image);
                Optional<ButtonType> result=alert.showAndWait();

            }

    }
    @FXML
    void send(ActionEvent event) {
        try {
            if (role.equals("User")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("User2Dashboard.fxml");
                //FXMLScene scene = FXMLScene.load("BackgroundDesign.fxml");
                Parent root = scene.root;
                UserDashboardController adminController = (UserDashboardController) scene.controller;
                //Back adminController = (Back) scene.controller;
                adminController.set(usern, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("UserProfile");
                stage.show();
            } else if (role.equals("Admin")) {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("AdminDashboard.fxml");
                Parent root = scene.root;
                AdminDashboardController adminController = (AdminDashboardController) scene.controller;
                adminController.set(usern, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Admin Dashboard");
                stage.show();
            } else {
                AdminDB.FXMLScene scene = AdminDB.FXMLScene.load("TeamDashboard.fxml");
                Parent root = scene.root;
                TeamDashboardController adminController = (TeamDashboardController) scene.controller;
                adminController.set(usern, role);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Team Home");
                stage.show();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private String logIn() {
        String status = "Success";
        System.out.println( password.getText());
         usern = username.getText();

         //role=sign_in_box.getValue().toString();
        //ad.set(usern);
        String passw = password.getText();
        if(usern.isEmpty() || passw.isEmpty() || sign_in_box.getSelectionModel().isEmpty()) {
           if(usern.isEmpty()) {
               userl.setVisible(true);
           }else {
               userl.setVisible(false);
           }
            if(passw.isEmpty()) {
                passl.setVisible(true);
            }else {
                passl.setVisible(false);
            }
            if(sign_in_box.getSelectionModel().isEmpty()){
                selectl.setVisible(true);
            }else {
                selectl.setVisible(false);
            }
            //status = "Success";
            status = "Errorr";
        } else {
           // System.out.println("Inbox");
            String sql = "SELECT * FROM userlist Where username = ? and password = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, usern);
                preparedStatement.setString(2, passw);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                   // status = "Success";
                    status = "Error";
                } else {

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }

        return status;
    }


    @FXML
    void sign_up(ActionEvent event) {
        try {
            root = FXMLLoader.load(Sign_UP.SignupController.class.getResource("Sign_UP.fxml"));
            // root = FXMLLoader.load(ProfileController.class.getResource("Profile.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Profile");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       @FXML
       private ImageView loginimage;
       @FXML
       private ImageView loginimage1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String items[]={"User","Volunteer Leader","Admin"};
        sign_in_box.getItems().addAll(items);
        sign_in_box.getSelectionModel().select(0);
        File file = new File("src/main/Font/user5.png");
        Image image = new Image(file.toURI().toString());
        user.setImage(image);
        file = new File("src/main/Font/pass.png");
        image = new Image(file.toURI().toString());
        pass.setImage(image);
        loginimage.setImage(new Image(new File("src/main/Font/login.png").toURI().toString()));
        loginimage1.setImage(new Image(new File("src/main/Font/add1.png").toURI().toString()));
    }
    @FXML
    private AnchorPane enter;


    @FXML
    public void enter1(KeyEvent e)
    {
        if(e.getCode().toString().equals("ENTER")|| e.getCode() == KeyCode.ENTER)
        {
            System.out.println("kaj hoise");
        }
    }
}
