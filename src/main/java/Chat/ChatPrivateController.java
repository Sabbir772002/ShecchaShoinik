package Chat;

import AdminDB.AdminDashboardController;
import AdminDB.TeamDashboardController;
import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import Others.TaskCompletedController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import UserProfile.ProfileEditController;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class ChatPrivateController implements Initializable{
    Connection con;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username = "";
    public String user2 = "";
    public String name2 = "";
    public String role = "";

    @FXML
    public TextField writebox;
    @FXML
    public Button Name2;
    @FXML
    public TextArea msgbox;
    BorderPane pane;

    public void set(String username, String role) {
        this.pane = pane;
       // user.setText(username);
       // rolee.setText("@" + role);
        this.role = role;
        this.username = username;
        loadimage();
        loadtable();
        refresh();
//        if(username.equals("Sabbir")){
//            user2="Nuha";
//        }else{
//            user2="Sabbir";
//        }
        //loadtable();
    }

    public void set(String username, String role, String name2, String user2, BorderPane pane) {
        this.pane = pane;
        //user.setText(username);
       // rolee.setText("@" + role);
        this.role = role;
        this.username = username;
        this.user2 = user2;
        this.name2 = name2;
        Name2.setText(name2);
        refresh();
        loadimage();
        loadtable();
        /*Thread chatwriter = new PrivateThread(msgbox,username,user2);
        chatwriter.start();*/

    }
    @FXML
    Circle image;
    void loadimage(){

        try{
            File file = new File("src/main/Font/Image/pp.png");

            FileOutputStream fos = new FileOutputStream(file);
            byte b[];
            Blob blob;
            System.out.println(user2);

            PreparedStatement ps = con.prepareStatement("select Image from pp where Username='"+user2+"'");
            ResultSet rs1 = ps.executeQuery();

            while (rs1.next()) {
                blob = rs1.getBlob("Image");
                b = blob.getBytes(1, (int) blob.length());
                fos.write(b);
            }
            ps.close();
            fos.close();
            System.out.println("Imgae Rerived successfully to " + file.getPath() + "  path");
            image.setFill(new ImagePattern(new Image(file.toURI().toString())));





        }catch(Exception e){

            System.out.println(e.getMessage());
        }
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
    void UserClick(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = fxmlLoader.load();
           ProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username, role,name2,user2,pane);
            pane.setCenter(ap);
        } catch (Exception e) {
            System.out.println("vul hoilo Admin Dashbaord profile button profile controller");
        }

    }

    @FXML
    void tableclick(MouseEvent event) {
       /* String Name2=usertable.getSelectionModel().getSelectedItem().getName().toString();
        String user2=usertable.getSelectionModel().getSelectedItem().getUsername().toString();*/
        try {

            String Name2 = usertable.getSelectionModel().getSelectedItem().getName().toString();
            String user2 = usertable.getSelectionModel().getSelectedItem().getUsername().toString();
            FXMLLoader fxmlLoader=new FXMLLoader();

            fxmlLoader.setLocation(Chat.ChatPrivateController.class.getResource("ChatPrivate.fxml"));
            AnchorPane pane1=fxmlLoader.load();
            ChatPrivateController adminController=fxmlLoader.getController();
            adminController.set(username, role, Name2, user2, pane);
            pane.setCenter(pane1);

        } catch (Exception e) {
            System.out.println("error on tabble click on chat private " + e.getMessage());
        }

    }

    @FXML
    private TableView<userlist> usertable;
    @FXML

    ObservableList<userlist> listF;

    ObservableList<userlist> getdiasterList() {
        ObservableList<userlist> userlist1 = FXCollections.observableArrayList();


        return userlist1;
    }

    int indexM = -1;

    void loadtable() {
        colname.setCellValueFactory(new PropertyValueFactory<userlist, String>("Name"));
        coluser.setCellValueFactory(new PropertyValueFactory<userlist, String>("Username"));
        //table.setItems(list);
        listF = ConnectionDb.getuserlist();
        usertable.setItems(listF);
        refresh();
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
                String s = resultSet.getString(3);
                // String s=writebox.getText().toString();
                char []c=s.toCharArray();
              /*  for(int i=0;i<c.length;i++){
                    c[i]=(char)(c[i]-10);

                }*/
                s=new String(c);
                msgbox.appendText(s/*resultSet.getString(3)*/);
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
                String s = resultSet.getString(3);
               // String s=writebox.getText().toString();
                char []c=s.toCharArray();
                for(int i=0;i<c.length;i++){
                    c[i]=(char)(c[i]-10);
                }
                s=new String(c);
                msgbox.appendText(s/*resultSet.getString(3)*/);
                msgbox.appendText("\n");
            }
            //sleep(1000);
            resultSet.close();


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
            String s=username+": "+writebox.getText().toString();
            char []c=s.toCharArray();
            /*for(int i=0;i<c.length;i++){
                c[i]=(char)(c[i]+10);
            }*/
            s=new String(c);
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
        preparedStatement.setString(3, s);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
        msgbox.appendText(username+" :"+writebox.getText());
        msgbox.appendText("\n");
        writebox.setText("");
            System.out.println("send message");

    }catch (Exception ie){

            System.out.println("from send privatechat "+ie.getMessage());
    }
}
@FXML
ImageView privateimage;
    @FXML
    ImageView person;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadimage();
      //  person.setImage(new Image(new File("src/main/Font/group.png").toURI().toString()));
        privateimage.setImage(new Image(new File("src/main/Font/account-circle-fill.png.png").toURI().toString()));

        //refresh();
        loadtable();
    }
    @FXML
    TextField search;
    //i++;
    @FXML
    void search(KeyEvent e){
        con=ConnectionDb.DBC();
        ObservableList<userlist> list1 = FXCollections.observableArrayList();
        //i++;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,BG,Gender,Phone,Volunteer FROM userlist");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String s1 = rs.getString(1);
                String s3 = rs.getString(2);
                String s5 = rs.getString(3);
                String s6 = rs.getString(4);
                String s7 = rs.getString(5);
                String s8 = rs.getString(6);
                String s9 = rs.getString(7);
                String s10 = rs.getString(8);

                String s0 = s1 + s3 + s5 + s6 + s7 + s8 + s9 + s10;


                String s2 = search.getText().toString() + "";
                // System.out.println(s2);
                boolean i = false;
                for (int j = 0; j < s0.length(); j++) {
                    for (int p = j + 1; p < s0.length() - 2; p++) {
                        if (s0.substring(j, p).equalsIgnoreCase(s2)) {
                            // System.out.println((s[j])+"=="+textfield.getText().toString());
                            i = true;
                        }
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
                    list1.add(new userlist(s1, s5));
                }
            }
        }catch (Exception ee){
            System.out.println("load problem on user");

        }
        try {
            //System.out.println("in team");

               PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,Phone,Type FROM Teams");

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                  //  System.out.println("in team");
                    String     s1 = rs.getString(1);
                    String     s3 = rs.getString(2);
                    String      s5 = rs.getString(3);
                    String   s6 = rs.getString(4);
                    String     s7 = rs.getString(5);
                    String      s8 = rs.getString(6);


                    String      s0 = s1 + s3 + s5+s6+s7+s8;
                    String  s2 = search.getText().toString() + "";
                    // System.out.println(s2);
                    boolean i = false;
                    for (int j = 0; j < s0.length(); j++) {
                        for (int p = j + 1; p < s0.length() - 2; p++) {
                            if (s0.substring(j, p).equalsIgnoreCase(s2)) {
                                // System.out.println((s[j])+"=="+textfield.getText().toString());
                                i = true;
                            }
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
                        //we can create another parameter for team or user
                        list1.add(new userlist(s1, s5));
                    }

            }
            // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
        } catch(Exception i){
            System.out.println("error at cmchat serch user" + i.getMessage());
        } finally{

            try {
                // con.close();
            } catch (Exception ee) {
            }
        }
        colname.setCellValueFactory(new PropertyValueFactory<userlist, String>("Name"));
        coluser.setCellValueFactory(new PropertyValueFactory<userlist, String>("Username"));
        usertable.setItems(list1);
    }

}

