package Event;

import AdminDB.Teams;
import AdminDB.User;
import DB.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ViewEvent implements Initializable {
    BorderPane pane;
    Connection con;
    String username,role;

    File file = new File("image2.png");
    FileOutputStream fos = new FileOutputStream(file);
    byte pic[];
    Blob blob;
    public ViewEvent() throws FileNotFoundException {
        eventclick11();
    }
    int Id=0;
    void eventclick11(){
        System.out.println("here i am");
        File file = new File("image2.png");
        try {
            FileOutputStream fos = new FileOutputStream(file);

            byte pic[];
            Blob blob;
            PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Division,District,Address,Author,Image FROM Event where Id="+list.get(0).Id +" order by id desc;");
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



    @FXML
     void eventclick(MouseEvent e)throws FileNotFoundException {
        int id=Integer.parseInt(eventtable.getSelectionModel().getSelectedItem().getId());
        File file = new File("image2.png");
        FileOutputStream fos = new FileOutputStream(file);
        byte pic[];
        Blob blob;
            try {
                PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Division,District,Address,Author,Image FROM Event where Id="+id+";");
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
                       imageview.setFitHeight(223);
                       imageview.setImage(new Image(file.toURI().toString()));
                }
                file.delete();
                fos.close();


        }catch (Exception ee){
            System.out.println(ee.getMessage());
        }

            }

 void eventclick1(){
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

            }






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
        if(role=="Team Leader") team.setVisible(true);
        if(role=="User") team.setVisible(false);
        con= ConnectionDb.DBC();
        this.pane = pane;
        this.username = username;
        this.role = role;
        eventclick11();
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
            PreparedStatement ps = con.prepareStatement("SELECT Title,Date,Id FROM Event where approve=1");
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
        title.setStyle("-fx-text-fill: #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER-LEFT;");
       title.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold;-fx-alignment:CENTER;");
       id.setStyle("-fx-text-fill:  #400401;-fx-border-color: transparent;-fx-font-weight: bold; -fx-alignment:CENTER;");

        con=ConnectionDb.DBC();
        loadtable();
    }

}
