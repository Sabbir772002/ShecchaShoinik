package Chat;

import DB.ConnectionDb;
import Others.Team;
import UserProfile.ProfileController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LiveHandeler extends Thread implements Initializable {
    Connection con;
    String username="";
    String role="";
    public HBox hboxmessage;
    public VBox vboxmessage;

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;


    @FXML
    BorderPane pane1;

    ;

    public void set(String username, String role) {
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        loadtable();
       // connect();
        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    BorderPane pane;
    public void set(String username, String role, BorderPane pane) {
        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        loadtable();
        this.pane1=pane;
        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();
       connect();

    }

    @FXML
    private TextField inputField;

    @FXML
    private TextArea showArea;

    @FXML
    private Label user2;

    @FXML
    private Label user21;





    @FXML
    private TableColumn<userlist, String> colname;

    @FXML
    private TableColumn<userlist, String> coluser;

    @FXML
    void tableclick(MouseEvent event) {
        String Name2=usertable.getSelectionModel().getSelectedItem().getName().toString();
        String user2=usertable.getSelectionModel().getSelectedItem().getUsername().toString();
        try{
            System.out.println("hey ki khobor");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,Name2,user2,pane1);
            //pane1.setVisible(false);
            pane1.setCenter(ap);
            //.setCenter(ap);
            System.out.println("kno holo na");

        }catch (Exception e){
            System.out.println(e.getMessage());
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
    boolean isConnected = false;
    BufferedReader reader;
    String inputName=username;
    BufferedWriter writer;
    Socket sc;

    void connect() {
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Connect With Server");

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);

            this.start();

        } catch (IOException e) {

        }


    }

    @FXML
    void send(ActionEvent e) {
        try {
            String msg = inputField.getText();
            printWriter.println(username + ":  " + msg + "  ");
//        txtClientPane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_RIGHT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            Text text = new Text(msg);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-color:rgb(239,242,255);"
                    + "-fx-background-color: rgb(246,137,32);" +
                    "-fx-background-radius: 20px; -fx-font-size: 15px");
            textFlow.setPadding(new Insets(5, 10, 5, 10));
            text.setFill(Color.color(0.934, 0.945, 0.996));
            hBox.getChildren().add(textFlow);
            vboxmessage.getChildren().add(hBox);
            printWriter.flush();

//        txtClientPane.appendText("Me: " + msg + "\n");
            inputField.setText("");
            if (msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
                System.exit(0);
            }

        } catch (Exception ie) {
            ie.printStackTrace();
        }
    }


    public void run() {
        try {
            while (true) {
                String msg = bufferedReader.readLine();
                System.out.println("Message : " + msg);
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println("cmd : " + cmd);
                StringBuilder fulmsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println("fulmsg : " + fulmsg);
                System.out.println();
                if (cmd.equalsIgnoreCase(username + ":")) {
                    continue;
                } else if (fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        HBox hBox = new HBox();
                        hBox.setAlignment(Pos.CENTER_LEFT);
                        hBox.setPadding(new Insets(5, 10, 5, 5));
                        Text text = new Text(msg);
                        TextFlow textFlow = new TextFlow(text);
                        textFlow.setStyle("-fx-color:rgb(239,242,255);"
                                + "-fx-background-color: rgb(182,182,182);" +
                                "-fx-background-radius: 10px;-fx-font-size: 15px");
                        textFlow.setPadding(new Insets(5, 0, 5, 5));
                        text.setFill(Color.color(0, 0, 0));
                        hBox.getChildren().add(textFlow);
                        vboxmessage.getChildren().add(hBox);

                    }
                });
                /*txtClientPane.appendText(msg + "\n");*/
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            try {
                bufferedReader.close();
                printWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }




    @FXML
    ObservableList<userlist> list= FXCollections.observableArrayList();
    @FXML
    TextField search;
    //i++;
    @FXML
    void search(KeyEvent e){
        ObservableList<userlist> list1 = FXCollections.observableArrayList();
        //i++;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,BG,Gender,Phone FROM userlist");
            ;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String s1 = rs.getString(1);
                String s3 = rs.getString(2);
                String s5 = rs.getString(3);
                String s6 = rs.getString(4);
                String s7 = rs.getString(5);
                String s8 = rs.getString(6);
                String s9 = rs.getString(7);

                String s0 = s1 + s3 + s5 + s6 + s7 + s8 + s9;


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
                System.out.println(ee.getMessage());
            }
           /* try{

                PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,Phone,Type FROM Teams");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                   // System.out.println("in team");
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
                        list1.add(new userlist(s1, s5));
                    }

            }*/
/*
            // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
        } catch(Exception i){
            System.out.println("error at cmchat serch user" + i.getMessage());
        } finally{

            try {
                // con.close();
            } catch (Exception ee) {
            }
        }*/
        colname.setCellValueFactory(new PropertyValueFactory<userlist, String>("Name"));
        coluser.setCellValueFactory(new PropertyValueFactory<userlist, String>("Username"));
        usertable.setItems(list1);
    }
   @FXML
   ImageView groupimage;
    @FXML
    ImageView privateimage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupimage.setImage(new Image(new File("src/main/Font/group.png").toURI().toString()));
        privateimage.setImage(new Image(new File("src/main/Font/logooo.png").toURI().toString()));

    }
}


