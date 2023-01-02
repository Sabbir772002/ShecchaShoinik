package UserProfile;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Optional;

public class ProfileEditController {
    Connection con;

    @FXML
    private Label Name;

    @FXML
    private Button bt11;

    @FXML
    private TextField district;

    @FXML
    private TextField division;

    @FXML
    private TextField mail;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private Label showuser;
    String username;
    String role;
    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        output();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }

    @FXML
    private Button imageup;



    String imagef = "src/main/Font/icons/profile.png";
    @FXML
    void upimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //final Button openButton = new Button("Choose Background Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Select Image", "*.jpg", "*.png","*.jpeg"));
        // fileChooser.setInitialDirectory(new File("C:\\Users\\USER\\Pictures"));e
        Node node=(Node)event.getSource();
       Stage stage = (Stage)node.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        System.out.println(imagef);
        if (file != null) {
            System.out.println(file);
            imagef = file.getAbsolutePath();
            System.out.println(imagef);
            String s[] = imagef.split("\\\\");
            //System.out.println(imagef);
            //  System.out.println(s[s.length - 1]);
            imageup.setText(s[s.length - 1]);
            // File f= new File("src/main/file.image");

            // openFile(file);
            // where my problem is

        }


    }
    @FXML
    void upload( ActionEvent e) {
        File file1=new File(imagef);
        try {
            Connection connection=ConnectionDb.DBC();
            FileInputStream fis = new FileInputStream(file1);
            String s = "Update pp set Image=? where Username=?";
            PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(s);
            preparedStatement2.setBinaryStream(1, fis, (int) file1.length());
            preparedStatement2.setString(2, username);
            preparedStatement2.execute();
            preparedStatement2.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Profile Picture Updated!");
            alert.setHeaderText("Profile Chaneged Succesfully!");
            // alert.setContentText("");
            File file = new File("src/main/Font/logooo.png");
            Image image = new Image(file.toURI().toString());
           Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            Optional<ButtonType> result=alert.showAndWait();


        } catch (Exception ee) {

            System.out.println(ee.getMessage());
        }
    }
    @FXML
    Circle image;
    public void output(){
        File file = new File("src/main/Font/Image/pp.png");

        try{
                Statement stmt=con.createStatement();
                String sql = "SELECT Name,Username,Phone,Division,District,Mail FROM userlist Where Username = \'"+username+"\'";
                //String sql = "SELECT * FROM `userlist` Where Username = '"+1+"'";
                //System.out.println("'"+user.getText()+"'");
                //SELECT Name,ID FROM `userlist` WHERE Username= "Nuha";
                //String s1="select * from teacher where Subject='PHYSICS'";
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next()) {
                    Name.setText(rs.getString(1));
                    showuser.setText(rs.getString(2));
                    phone.setText(rs.getString(3));
                    division.setText(rs.getString(4));
                    district.setText(rs.getString(5));
                    mail.setText(rs.getString(6));


                }
                FileOutputStream fos = new FileOutputStream(file);
                byte b[];
                Blob blob;

                PreparedStatement ps = con.prepareStatement("select Image from pp where Username='"+username+"'");
                ResultSet rs1 = ps.executeQuery();

                while (rs1.next()) {
                    blob = rs1.getBlob("Image");
                    b = blob.getBytes(1, (int) blob.length());
                    fos.write(b);
                }
                image.setFill(new ImagePattern(new Image(file.toURI().toString())));
                ps.close();
                fos.close();
                rs.close();
                stmt.close();
                name.setText(Name.getText().toString());
                String uname = showuser.getText().toString();
           /* System.out.println(uname);
            System.out.println(username);*/
                //System.out.println(user.getText().toString());
                if(username.toString().equals(uname)) {
                    // pfield.setText("Edit"); //pore add korbo
                }else{

                }
                showuser.setText("@"+showuser.getText().toString());
            } catch (Exception ex) {
                System.out.println("onk error");
                System.err.println(ex.getMessage());
            }
        }

        @FXML
    void Save(ActionEvent event) {
         Stage stage;
         Parent root;


           PreparedStatement preparedStatement;
            try {
                con= ConnectionDb.DBC();
                String st = "update userlist set Name=?,Phone=?,Division=?,District=?,Mail=? WHERE Username ='"+username+"'";
                preparedStatement = (PreparedStatement) con.prepareStatement(st);
                preparedStatement.setString(1, name.getText());
                preparedStatement.setString(2, phone.getText());
                preparedStatement.setString(3, division.getText());
                preparedStatement.setString(4, district.getText());
                preparedStatement.setString(5, mail.getText());
                preparedStatement.execute();
                output();
                con=ConnectionDb.DBC();
                String st1 = "update volunteer set Name=?,Phone=?,Division=?,District=?,Mail=? WHERE Username ='"+username+"'";
                PreparedStatement ps= (PreparedStatement) con.prepareStatement(st1);
                ps.setString(1, name.getText());
                ps.setString(2, phone.getText());
                ps.setString(3, division.getText());
                ps.setString(4, district.getText());
                ps.setString(5, mail.getText());
                ps.execute();
                ps.close();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Profile Update");
                alert.setHeaderText("Profile Updated Succesfully!");
                // alert.setContentText("");
                File file = new File("src/main/Font/icon1.png");
                Image image = new Image(file.toURI().toString());
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);
                Optional<ButtonType> result=alert.showAndWait();

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

