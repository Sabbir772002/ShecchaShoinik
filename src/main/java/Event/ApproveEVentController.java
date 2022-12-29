package Event;

import AdminDB.AdminDashboardController;
import AdminDB.FXMLScene;
import AdminProfile.AdminProfileController;
import BloodBank.BloodBankController;
import DB.ConnectionDb;
import Others.TeamApproveController;
import PostBox.AddPostController;
import Sign_in.SigninController;
import UserProfile.ProfileController;
import com.example.sheccashoinik.Application;
import com.example.sheccashoinik.disaster;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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

public class ApproveEVentController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String username="";
    public String role="";
        BorderPane pane;
        Connection con;
     int Id=0;

        @FXML
        void eventclick(MouseEvent e)throws Exception {
            File file = new File("image2.png");
            FileOutputStream fos = new FileOutputStream(file);
            byte pic[];
            Blob blob;
            Id=Integer.parseInt(eventtable.getSelectionModel().getSelectedItem().getId());
            try {
                PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Division,District,Address,Author,Image FROM Event where Id="+Id+" order by id desc;");
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    Title.setText(rs.getString(1));
                    date.setText(rs.getString(2));
                    division.setText(rs.getString(3));
                    district.setText(rs.getString(4));
                    address.setText(rs.getString(5));
                    author.setText(rs.getString(6));
                    blob = rs.getBlob(7);
                    pic = blob.getBytes(1, (int) blob.length());
                    fos.write(pic);
                    imageview.setFitWidth(365);
                    imageview.setFitHeight(180);
                    imageview.setImage(new Image(file.toURI().toString()));
                }
                 file.delete();
                fos.close();
            }catch (Exception ee){
                System.out.println(ee.getMessage());
            }

        }

        void eventclick(){
            File file = new File("image2.png");
            try {
                FileOutputStream fos = new FileOutputStream(file);

            byte pic[];
            Blob blob;
                PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Division,District,Address,Author,Image FROM Event where Id="+3+" order by id desc;");
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    Title.setText(rs.getString(1));
                    date.setText(rs.getString(2));
                    division.setText(rs.getString(3));
                    district.setText(rs.getString(4));
                    address.setText(rs.getString(5));
                    author.setText(rs.getString(6));
                    blob = rs.getBlob(7);
                    pic = blob.getBytes(1, (int) blob.length());
                    fos.write(pic);
                    imageview.setFitWidth(365);
                    imageview.setFitHeight(180);
                    imageview.setImage(new Image(file.toURI().toString()));
                }
                 file.delete();
                fos.close();
            }catch (Exception ee){
                System.out.println(ee.getMessage());
            }

        }


       /* void eventclick(){
            // int id=Integer.parseInt(eventtable.getSelectionModel().getSelectedItem().getId());

            try {
                PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Division,District,Address,Author FROM Event where Id="+1+";");
                ResultSet rs = ps.executeQuery();
                // System.out.println("loadevent");
                if(rs.next()) {
                    Title.setText(rs.getString(1));
                    date.setText(rs.getString(2));
                    division.setText(rs.getString(3));
                    district.setText(rs.getString(4));
                    address.setText(rs.getString(5));
                    author.setText(rs.getString(6));
                }

            }catch (Exception ee){
                System.out.println(ee.getMessage());
            }

        }*/






        @FXML
        void addevent(ActionEvent e){
            try{
                System.out.println("aslo to");
                //System.out.println("hey ki khobor");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(EventForm.class.getResource("EventForm.fxml"));
                AnchorPane ap = fxmlLoader.load();
                EventForm sadmin = fxmlLoader.getController();
                sadmin.set(username,role,pane);
                pane.setCenter(ap);
                //System.out.println("kno holo na");

            }catch (Exception ei){
                System.out.println(ei.getMessage());
            }

        }
        @FXML
        Button team;

        public void set(String username, String role, BorderPane pane) {
            if(role=="Volunteer Leader") team.setVisible(true);
            if(role=="User") team.setVisible(false);
            con= ConnectionDb.DBC();
            this.pane = pane;
            this.username = username;
            this.role = role;
            // user.setText(username);
            // rolee.setText("@"+role);

        }
        @FXML
        private Label address;

        @FXML
        private Label author;

        @FXML
        private Label date;

        @FXML
        private Label district;

        @FXML
        private Label division;
        @FXML
        private Label Title;

        @FXML
        private TableView<EventView> eventtable;

        @FXML
        private ImageView imageview;

        @FXML
        private TextField search;

        @FXML
        private TableColumn<EventView, String> title;
        @FXML
        private TableColumn<EventView, String> id;

        @FXML
        void serchkey(MouseEvent event) {

        }

        @FXML
        private TableColumn<EventView,String> time;

        ObservableList<EventView> list = FXCollections.observableArrayList();

        ObservableList<EventView> loadEvent(){
            ObservableList<EventView>list = FXCollections.observableArrayList();

            try {
                PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Id FROM Event order by Id desc");
                ResultSet rs = ps.executeQuery();
                System.out.println("loadpost");
                while (rs.next()) {
                    list.add(new EventView(rs.getString(1),rs.getString(2),String.valueOf(rs.getInt(3))));
                }
            }catch(Exception e){
                System.out.println(e.getMessage());

            }


            return list;
        }
        void loadtable() {
            System.out.println("table");
            title.setCellValueFactory(new PropertyValueFactory<EventView,String>("Title"));
            time.setCellValueFactory(new PropertyValueFactory<EventView, String>("Date"));
            id.setCellValueFactory(new PropertyValueFactory<EventView, String>("Id"));
            list = loadEvent();
            eventtable.setItems(list);

        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            con=ConnectionDb.DBC();
            loadtable();
            eventclick();
        }




    public void set(String username,String role) {

        this.role = role;
        this.username = username;
    }
    @FXML
    void Approve(ActionEvent event) {
        try {
            con=ConnectionDb.DBC();
            String st = "Update event set Approve='1' WHERE ID=" + Id+"";
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
            preparedStatement.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Event Approved Successfully");
            alert.setHeaderText("Click ok to Back!");
            File file = new File("src/main/Font/icon1.png");
            Image image = new Image(file.toURI().toString());
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(image);
            // alert.initOwner(stage);
            //alert.setGraphic(new ImageView(image));
            //user.setImage(image);
            Optional<ButtonType> result = alert.showAndWait();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.ControlPanelController.class.getResource("ControlPanel.fxml"));
            AnchorPane ap = fxmlLoader.load();
            AdminDB.ControlPanelController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane);
            pane.setCenter(ap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/


    }
    @FXML
    void Decline(ActionEvent event) {
                try {
                        con=ConnectionDb.DBC();
                        String st = "Delete  from event WHERE ID=" + Id+"";
                        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(st);
                        preparedStatement.execute();
                        System.out.println("User deleted");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Event deleted Successfully");
                        alert.setHeaderText("Click ok to Back!");
                        File file = new File("src/main/Font/icon1.png");
                        Image image = new Image(file.toURI().toString());
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(image);
                        // alert.initOwner(stage);
                        //alert.setGraphic(new ImageView(image));
                        //user.setImage(image);
                        Optional<ButtonType> result = alert.showAndWait();
                    }catch (Exception e) {
                    System.out.println(e.getMessage());
}
        /*try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(AdminDB.ControlPanelController.class.getResource("ControlPanel.fxml"));
            AnchorPane ap = fxmlLoader.load();
            AdminDB.ControlPanelController sadmin = fxmlLoader.getController();
            sadmin.set(username, role, pane);
            pane.setCenter(ap);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/



    }
}


