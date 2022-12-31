package Others;

import BloodBank.User;
import Chat.userlist;
import DB.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VolunteerNearController implements Initializable {
    Connection con;
    String username="";
    String role="";
    @FXML
    void mail(MouseEvent e){

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.MAIL)) {
                    URI mailto = new URI("mailto:"+Phone1.getText().toString());
                    desktop.mail(mailto);
                }
            }
        }catch (Exception ee )
        {
            System.out.println(ee.getMessage());
        }
    }
    public void set(String username, String role) {
        if(!role.equals("User")){joinb.setVisible(false);}else{joinb.setVisible(true);}

        con= ConnectionDb.DBC();
        role=role;
        this.role = role;
        this.username = username;
        loadduserinfo();
        loadtable();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    BorderPane pane;
    @FXML
    void join(ActionEvent event) {
        try{
            System.out.println(username2);
            PreparedStatement preparedStatement;
            con= ConnectionDb.DBC();
            String st = "update Volunteer set Teams=? WHERE Username ='"+username+"'";
            preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.setString(1, username2);
            preparedStatement.execute();
            preparedStatement.close();
            con.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    @FXML
    Button joinb;

    public void set(String username, String role, BorderPane pane) {
        if(!role.equals("User")){
            joinb.setVisible(false);
        }
        con=ConnectionDb.DBC();
        this.pane=pane;
        // user.setText(username);
        // rolee.setText("@"+role);
        this.role = role;
        this.username = username;
        loadduserinfo();
        loadtable();
    }
    String division, district;
    void loadduserinfo(){
        try {
            System.out.println(username);
            PreparedStatement ps = con.prepareStatement("SELECT District,Division FROM userlist where Username='" + username + "'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                district=rs.getString(1);
                division=rs.getString(2);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

            }


    }


    @FXML
    private Label District;

    @FXML
    private Label Division;

    @FXML
    private Label Name;

    @FXML
    private Label Phone;

    @FXML
    private Label Phone1;

    @FXML
    private Label Phone11;

    @FXML
    private Button btsearch;

    @FXML
    private Label field;

    @FXML
    private Label field1;

    @FXML
    private Label showuser;
    @FXML
    private TableView<Team> vtable;
    @FXML
    private TableColumn<Team, String> col_district;

    @FXML
    private TableColumn<Team, String> col_name;

    @FXML
    private TableColumn<Team, String> col_user;
    String username2="TeamDurbar";
    @FXML
    ObservableList<Team> listF;

    ObservableList<Team> getdiasterList() {
        ObservableList<Team> userlist1 = FXCollections.observableArrayList();


        return userlist1;
    }

    int indexM = -1;
    @FXML
    private TextField search;;
    @FXML
    void keyclick(KeyEvent e) {
        ObservableList<Team> list1 = FXCollections.observableArrayList();
        //i++;


        Connection con;
        //= ConnectionDb.DBC();
        //ObservableList<diaster>list = FXCollections.observableArrayList();
        try {

            con = ConnectionDb.DBC();
            try {
                loadduserinfo();
               // System.out.println(district+" "+division);
                // System.out.println("hlw");
                PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,Type,Phone,Availablity FROM Teams where District='" + district + "'");
                ;
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String s1 = rs.getString(1);
                    String s3 = rs.getString(2);
                    String s5 = rs.getString(3);
                    String s6 = rs.getString(4);
                    String s7 = rs.getString(5);
                    String s8 = rs.getString(6);
                    String s9 = String.valueOf(rs.getInt(7));
                    // System.out.println(s5);
                    String s0 = s1 + s3 + s5+s6+s7+s8+s9;

                    String s4[] = s0.split(" ");


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
                        list1.add(new Team(s1, s3, s5));
                    }


                }
                ps = con.prepareStatement("SELECT Name,District,Username,Division,Type,Phone,Availablity FROM Teams where Division='" + division + "' And District!='"+district +"'");
                ;
                rs = ps.executeQuery();
                while (rs.next()) {

                    String s1 = rs.getString(1);
                    String s3 = rs.getString(2);
                    String s5 = rs.getString(3);
                    String s6 = rs.getString(4);
                    String s7 = rs.getString(5);
                    String s8 = rs.getString(6);
                    String s9 = String.valueOf(rs.getInt(7));
                    // System.out.println(s5);
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
                        list1.add(new Team(s1, s3, s5));
                    }
                }

                ps = con.prepareStatement("SELECT Name,District,Username,Division,Type,Phone,Availablity FROM Teams where Division!='" + division + "'");
                    ;
                    rs = ps.executeQuery();
                    while (rs.next()) {

                    String     s1 = rs.getString(1);
                   String     s3 = rs.getString(2);
                   String      s5 = rs.getString(3);
                     String   s6 = rs.getString(4);
                    String     s7 = rs.getString(5);
                   String      s8 = rs.getString(6);
                   String    s9 = String.valueOf(rs.getInt(7));

                    String      s0 = s1 + s3 + s5+s6+s7+s8+s9;



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
                            list1.add(new Team(s1, s3, s5));
                        }


                    }
                    // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
                } catch(Exception i){
                    System.out.println("error at bank serch user backlist" + i.getMessage());
                } finally{

                    try {
                        // con.close();
                    } catch (Exception ee) {
                    }
                }
                col_name.setCellValueFactory(new PropertyValueFactory<Team, String>("Name"));
                col_user.setCellValueFactory(new PropertyValueFactory<Team, String>("Username"));
                col_district.setCellValueFactory(new PropertyValueFactory<Team, String>("District"));
                vtable.setItems(list1);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


    void loadtable() {
        col_name.setCellValueFactory(new PropertyValueFactory<Team, String>("Name"));
        col_district.setCellValueFactory(new PropertyValueFactory<Team, String>("District"));
        col_user.setCellValueFactory(new PropertyValueFactory<Team, String>("Username"));
        listF = ConnectionDb.getTeamlist(division,district);
         vtable.setItems(listF);

    }





    @FXML
    void helpclcik(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }


    @FXML
    void tableclick(MouseEvent e) {
        String t=vtable.getSelectionModel().getSelectedItem().getUsername();
        try {
            con=ConnectionDb.DBC();
            PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,Type,Phone,Availablity,Mail FROM Teams where Username='" +t+ "'");
            ;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String s1 = rs.getString(1);
                String s3 = rs.getString(2);
                String s5 = rs.getString(3);
                String s6 = rs.getString(4);
                String s7 = rs.getString(5);
                String s8 = rs.getString(6);
                String s9 = String.valueOf(rs.getInt(7));
                String s10 = rs.getString(8);
                username2=s5;
              Name.setText(s1);
              showuser.setText("@"+s5);
              Division.setText(s3);
              District.setText(s6);
              field.setText(s7);
              field1.setText(s9.equals("1")?"True":"False");
              Phone.setText(s8);
              Phone1.setText(s10);

            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    void tableclick( ) {
        String t="TeamDurbar";
        try {
            PreparedStatement ps = con.prepareStatement("SELECT Name,District,Username,Division,Type,Phone,Availablity,Mail FROM Teams where Username='" + t + "'");
            ;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String s1 = rs.getString(1);
                String s3 = rs.getString(2);
                String s5 = rs.getString(3);
                String s6 = rs.getString(4);
                String s7 = rs.getString(5);
                String s8 = rs.getString(6);
                String s9 = String.valueOf(rs.getInt(7));
                String s10 = rs.getString(8);
                Name.setText(s1);
                showuser.setText("@"+s5);
                Division.setText(s3);
                District.setText(s6);
                field.setText(s7);
                field1.setText(s9.equals("1")?"True":"False");
                Phone.setText(s8);
                Phone1.setText(s10);

            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con=ConnectionDb.DBC();
        tableclick();
      /*  loadduserinfo();
        loadtable();*/
    }
}


