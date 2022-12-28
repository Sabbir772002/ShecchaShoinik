package AdminDB;

import DB.ConnectionDb;
import TeamProfile.TeamProfileController;
import UserProfile.ProfileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControlPanelController implements Initializable {
    Connection con;
    public ControlPanelController() {
        con = ConnectionDb.DBC();
    }
    String username;
    String role;
    BorderPane pane;
    String division="", district="";



        @FXML
        private TableColumn<User,String> District;

        @FXML
        private TableColumn<User, String> Name;

        @FXML
        private TableColumn<Post, String> PostDistrict;

        @FXML
        private TableColumn<Post,String> PostType;

        @FXML
        private TableColumn<Teams, String> TeamDistrict;

        @FXML
        private TableColumn<Teams, String> TeamType;

        @FXML
        private TableColumn<Teams, String> Teamname;

        @FXML
        private TableColumn<Post, String> title;

        @FXML
        private TableColumn<Teams, String> Teamuser;

        @FXML
        private TableColumn<User,String> Username;
        @FXML
        private TableColumn<Post,String> ID;

        @FXML
        private TableView<User> alluser;

        @FXML
        private TableView<Post> post;

        @FXML
        private TableView<Teams> team;

    void loadduserinfo(){
        try {
            System.out.println("loaduserinfo");
            System.out.println(username);

            PreparedStatement ps = con.prepareStatement("SELECT Division FROM admin where Username='" + username + "'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                division=rs.getString(1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }


    }
    @FXML
    void tableclickpost(MouseEvent event) {
        //System.out.println(table.getSelectionModel().getSelectedItem().getId());
        try {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(PostBox.Post.class.getResource("PostView.fxml"));
                AnchorPane ap = fxmlLoader.load();
                PostBox.Post sadmin = fxmlLoader.getController();
                //sadmin.set(username,role);


                sadmin.set(username, role, Integer.parseInt(post.getSelectionModel().getSelectedItem().getID()),pane);
                pane.setCenter(ap);
                Connection con = ConnectionDb.DBC();
                try {
                    String sql = "SELECT * FROM notify Where username = ? and Postid = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setInt(2,Integer.parseInt(post.getSelectionModel().getSelectedItem().getID()));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {
                        PreparedStatement ps1 = con.prepareStatement("insert into `notify`  (Username,Postid) values (?,?);");
                        // ResultSet rs1= ps1.executeQuery();
                        ps1.setString(1, username);
                        ps1.setInt(2, Integer.parseInt(post.getSelectionModel().getSelectedItem().getID()));
                        ps1.execute();
                        ps1.close();
                        //rs1.close();
                    } else {
                        ;
                        System.out.println("ase aita");
                    }
                    resultSet.close();
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
    @FXML
    void tableclickteam(MouseEvent event) {

        String Name2=team.getSelectionModel().getSelectedItem().getName().toString();
        String user2=team.getSelectionModel().getSelectedItem().getUsername().toString();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(TeamProfile.TeamProfileController.class.getResource("TeamProfile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            TeamProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,Name2,user2,pane);
            //pane1.setVisible(false);
            pane.setCenter(ap);
            //.setCenter(ap);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    @FXML
    void tableclickuser(MouseEvent event) {
        String Name2=alluser.getSelectionModel().getSelectedItem().getName().toString();
        String user2=alluser.getSelectionModel().getSelectedItem().getUsername().toString();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(UserProfile.ProfileController.class.getResource("Profile.fxml"));
            AnchorPane ap = fxmlLoader.load();
            ProfileController sadmin = fxmlLoader.getController();
            sadmin.set(username,role,Name2,user2,pane);
            //pane1.setVisible(false);
            pane.setCenter(ap);
            //.setCenter(ap);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    ObservableList<User>list = FXCollections.observableArrayList();

    ObservableList<User> loadusers(){
        ObservableList<User>list = FXCollections.observableArrayList();
        try {
           System.out.println(division);
           PreparedStatement ps = con.prepareStatement("SELECT Name,Username,District FROM userlist where Division='" + division + "'");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
             list.add(new User(rs.getString(1),rs.getString(2),rs.getString(3)));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());

       }


       return list;
   } ObservableList<Post>listp = FXCollections.observableArrayList();

    ObservableList<Post> loadpost(){
        ObservableList<Post>list = FXCollections.observableArrayList();

        try {
           System.out.println(division);

           PreparedStatement ps = con.prepareStatement("SELECT Title,District,Type,Id FROM diasterlist where Division='" + division + "'");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
             list.add(new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)+""));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());

       }

       return list;
   }
          ObservableList<Teams>listt = FXCollections.observableArrayList();

    ObservableList<Teams> loadteams(){
        ObservableList<Teams>list = FXCollections.observableArrayList();

        try {
           System.out.println(division);

           PreparedStatement ps = con.prepareStatement("SELECT Name,Username,District,Type FROM teams where Division='" + division + "'");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
             list.add(new Teams(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());

       }


       return list;
   }
   void loadtable() {
        Name.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        District.setCellValueFactory(new PropertyValueFactory<User, String>("District"));
        Username.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
        list = loadusers();
        System.out.println(list);
        alluser.setItems(list);

    }
void loadtablep() {
        title.setCellValueFactory(new PropertyValueFactory<Post,String>("Title"));
        PostDistrict.setCellValueFactory(new PropertyValueFactory<Post, String>("District"));
        PostType.setCellValueFactory(new PropertyValueFactory<Post, String>("type"));
        ID.setCellValueFactory(new PropertyValueFactory<Post, String>("ID"));
        listp = loadpost();
        post.setItems(listp);

    }
    void loadtablet() {
       Teamname.setCellValueFactory(new PropertyValueFactory<Teams,String>("Name"));
       TeamDistrict.setCellValueFactory(new PropertyValueFactory<Teams, String>("District"));
        Teamuser.setCellValueFactory(new PropertyValueFactory<Teams, String>("Username"));
        TeamType.setCellValueFactory(new PropertyValueFactory<Teams, String>("Type"));
        listt = loadteams();
        team.setItems(listt);

    }



    @FXML
    public void viewuser(ActionEvent actionEvent) {
        alluser.setVisible(true);
        team.setVisible(false);
        post.setVisible(false);

    }
    @FXML
    public void viewteam(ActionEvent actionEvent) {
        team.setVisible(true);
        alluser.setVisible(false);
        post.setVisible(false);

    }
    @FXML
    public void viewpost(ActionEvent actionEvent) {
        post.setVisible(true);
        alluser.setVisible(false);
        team.setVisible(false);
    }

    public void set(String username, String role, BorderPane pane1) {
        con=ConnectionDb.DBC();
        this.username = username;
        this.role = role;
        this.pane = pane1;
        loadduserinfo();
        loadusers();
        loadtable();
        loadpost();
        loadtablep();
        loadteams();
        loadtablet();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loadduserinfo();
//        loadusers();
//        loadtable();
    }
    @FXML
    void eventclick(MouseEvent event) {


    }
    @FXML
   void tablcclickpost(ActionEvent event) {


    }
}
