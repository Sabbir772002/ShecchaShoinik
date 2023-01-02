package Sign_in;
import java.io.File;
import java.lang.Math;
import DB.ConnectionDb;
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
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class ForgetController implements Initializable {

        @FXML
        private TextField mail;

        @FXML
        private Label passl;

        @FXML
        private Label selectl;

        @FXML
        private ComboBox<String> sign_in_box;

        @FXML
        private Label userl;

        @FXML
        private TextField username;
        @FXML
        TextField pass;
        @FXML
        TextField code;
        @FXML
        Button forgetb;
        @FXML
        Button changeb;
        Connection con;
   int c=0;
        @FXML
        void change(ActionEvent e)  {
                 if(c==Integer.parseInt(code.getText().toString())){
    Connection con=ConnectionDb.DBC();
                try {
                    String  s;
                    if(role.equals("User")){
                        s="Update userlist set password='"+pass.getText().toString()+"' where username='"+Username+"'";

                    }else{

                   s="Update teams set pass='"+pass.getText().toString()+"' where username='"+Username+"'";


                    }
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setHeaderText("Password Changed Successfully");
                     alert.setContentText("Your Password Changed Succesfully!\n" +
                             "Please login to use!\n");
                     alert.showAndWait();
                     try {
                         Parent root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                         Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                         Scene scene = new Scene(root);
                         stage.setScene(scene);
                         stage.setTitle("SIGN IN");
                         stage.show();
                     } catch (Exception en) {
                         System.out.println(en.getMessage());
                     }


                 }else{

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Your code doesn't match.");
                alert.setContentText("Please enter correct code.\n");
                alert.showAndWait();
            }

              }
              @FXML
              Label s1;
               @FXML
              Label s2;
              @FXML
              Label s3;
              String Username,role,password;

        @FXML
        void forget(ActionEvent event) {
            int n=(int)((Math.random()*100)+1);
             c=n;
            System.out.println(n);
            System.out.println(c);
            int f = 1,t=1;
            con = ConnectionDb.DBC();
            Username=username.getText().toString();
            role=sign_in_box.getValue().toString();
            if(username.getText().isEmpty() || mail.getText().isEmpty() || sign_in_box.getSelectionModel().isEmpty()){
                if(username.getText().isEmpty()){
                    s2.setVisible(true);
                }
                if(mail.getText().isEmpty()){
                    s3.setVisible(true);
                }
                if(sign_in_box.getSelectionModel().isEmpty()) {
                    s1.setVisible(true);

                }
                f=0;
                t=0;
                /* Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Info Missing");
                alert.setHeaderText("");
                alert.setContentText("Please input data properly!");
                alert.showAndWait();*/

            } else if (sign_in_box.getValue().toString().equals("User")) {

                // System.out.println("Inbox");
                String sql = "SELECT * FROM userlist Where username = ? and Mail = ?";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, username.getText().toString());
                    preparedStatement.setString(2, mail.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {
                        f = 0;
                    } else {
                    }
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            } else if (sign_in_box.getValue().toString().equals("Team Leader")) {

                // System.out.println("Inbox");
                String sql = "SELECT * FROM teams Where username = ? and mail = ? and approve=1";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, username.getText().toString());
                    preparedStatement.setString(2, mail.getText().toString());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {
                        f = 0;
                    } else {

                    }
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (f == 1) {

                String to = mail.getText().toString();

                final String from = "sabbir772002@gmail.com";

                String host = "smtp.gmail.com";

                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");

                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(from, "qcldrekxkctrftaf");

                    }

                });

                session.setDebug(true);

                try {
                    // Create a default MimeMessage object.
                    MimeMessage message = new MimeMessage(session);

                    // Set From: header field of the header.
                    message.setFrom(new InternetAddress(from));

                    // Set To: header field of the header.
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                    // Set Subject: header field
                    message.setSubject("This is the code for Recover your \"Sheccashoinik\" password");
                    String msg = "<p><h2>Your Password Reset Code is: " + n + "</h2>\nPlease dont share this code with others.</p>";
                    // Now set the actual message
                    //  message.setText("This is actual message");
                    message.setContent(msg, "text/html");

                    System.out.println("sending...");
                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    Image image = new Image(new File("src/main/Font/logooo.png").toURI().toString());
                    Stage   stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(image);
                    alert.setHeaderText("Send code Sucessfully");
                    alert.setContentText("Code sent succesfully! Please Check your Mail.");
                    alert.showAndWait();
                    s1.setVisible(false);s2.setVisible(false);s3.setVisible(false);
                    username.setVisible(false);
                    mail.setVisible(false);
                    forgetb.setVisible(false);
                    code.setVisible(true);
                    pass.setVisible(true);
                    changeb.setVisible(true);

                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }

            }else if(t==1) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Send code failed");
                alert.setContentText("Please try again! \nYour Given information not matched!");
                Image image = new Image(new File("src/main/Font/logooo.png").toURI().toString());
             Stage   stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(image);

                alert.showAndWait();
            }
        }

        @FXML
        public void signin(ActionEvent event){
                try {
                    Parent root = FXMLLoader.load(SigninController.class.getResource("Sign_in.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("SIGN IN");
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            String role[]={"User","Team Leader"};
             sign_in_box.getItems().addAll(role);
             sign_in_box.getSelectionModel().select(0);

    }
}
