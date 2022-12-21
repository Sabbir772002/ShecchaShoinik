package AdminDB;

import DB.ConnectionDb;
import PostBox.Post;
import com.example.sheccashoinik.disaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.GestureEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeboardController implements Initializable {


        @FXML
        private Button btsearch;
        @FXML
        private BorderPane pane1;

        @FXML
        private TableView<disaster> table;

        @FXML
        private TextField textfield;
        @FXML
        private TableColumn<disaster, String> col_address;

        @FXML
        private TableColumn<disaster, String> col_district;

        @FXML
        private TableColumn<disaster, String> col_title;

        @FXML
        private TableColumn<disaster, String> col_type;

        @FXML
        private TableColumn<disaster, Integer> col_id;


        ObservableList<disaster> listF;

        @FXML
        void keyclick(KeyEvent e) {
                ObservableList<disaster> list = FXCollections.observableArrayList();
                //i++;
                if (e.getCode() != KeyCode.ENTER) {
                        return;
                }
                if (e.getCode() == KeyCode.ENTER) {
                        Connection con = ConnectionDb.DBC();
                        //ObservableList<diaster>list = FXCollections.observableArrayList();
                        try {
                /*PreparedStatement ps =  con.prepareStatement(
                        "SELECT * FROM `diasterlist` WHERE" +
                                      " Division='"+textfield.getText().toString()
                                    +"' OR District='"+textfield.getText().toString()
                                    +"' OR `Title`='"+textfield.getText().toString()
                                    +"' OR `Type`='"+textfield.getText().toString()
                                    +"' OR `Address`='"+textfield.getText().toString()
                                    +"' OR `AddInfo`='"+textfield.getText().toString()
                                    +"' OR `Id`='"+textfield.getText().toString()
                                    +"' ORDER BY Id DESC;");*/
                                PreparedStatement ps = con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
                                ResultSet rs = ps.executeQuery();
                                // +"' OR `Title`='"+textfield.getText().toString()
               /* ps.setString(1,textfield.getText().toString());
                ps.setString(2,textfield.getText().toString());*/
                                // ps.setString(1,textfield.getText().toString());
                                while (rs.next()) {
                                        String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (rs.getInt(6)) + "", rs.getString(7)};
                                        String s1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5] + " " + s[6];
                                        String s5[] = s1.split(" ");

                                        String s2 = textfield.getText().toString() + "";
                                        // System.out.println(s2);
                                        boolean i = false;
                                        for (int j = 0; j < s5.length; j++) {
                                                // System.out.println(textfield.getText().toString());
                                                // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/
                                                if (s5[j].equalsIgnoreCase(s2)) {
                                                        // System.out.println((s[j])+"=="+textfield.getText().toString());
                                                        i = true;
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
                                                list.add(new disaster(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6]));
                                        }

                                }
                                // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
                        } catch (Exception ie) {
                                System.out.println("error at disaster backlist");
                        } finally {

                                try {
                                        con.close();
                                } catch (Exception ee) {
                                }
                        }
                        listF = list;
                        loadtable1();
                } else {
                        //i=0;
                        System.out.println("onk bar cole code");
                        loadtable();
                }


        }
        @FXML
        void search(ActionEvent e) {
                ObservableList<disaster> list = FXCollections.observableArrayList();
                //i++;


                Connection con = ConnectionDb.DBC();
                //ObservableList<diaster>list = FXCollections.observableArrayList();
                try {
                /*PreparedStatement ps =  con.prepareStatement(
                        "SELECT * FROM `diasterlist` WHERE" +
                                      " Division='"+textfield.getText().toString()
                                    +"' OR District='"+textfield.getText().toString()
                                    +"' OR `Title`='"+textfield.getText().toString()
                                    +"' OR `Type`='"+textfield.getText().toString()
                                    +"' OR `Address`='"+textfield.getText().toString()
                                    +"' OR `AddInfo`='"+textfield.getText().toString()
                                    +"' OR `Id`='"+textfield.getText().toString()
                                    +"' ORDER BY Id DESC;");*/
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM `diasterlist` ORDER BY Id DESC;");
                        ResultSet rs = ps.executeQuery();
                        // +"' OR `Title`='"+textfield.getText().toString()
               /* ps.setString(1,textfield.getText().toString());
                ps.setString(2,textfield.getText().toString());*/
                        // ps.setString(1,textfield.getText().toString());
                        while (rs.next()) {
                                String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (rs.getInt(6)) + "", rs.getString(7)};
                                String s1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5] + " " + s[6];
                                String s5[] = s1.split(" ");

                                String s2 = textfield.getText().toString() + "";
                                // System.out.println(s2);
                                boolean i = false;
                            for (int j = 0; j < s1.length(); j++) {
                                for(int p = j+1; p < s1.length()-1; p++) {
                                    // System.out.println(textfield.getText().toString());
                                    // System.out.println(s2);
/*
                        if(s[j]==textfield.getText().toString()){
*/
                                    if (s1.substring(j, p).equalsIgnoreCase(s2)) {
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
                                        list.add(new disaster(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6]));
                                }

                        }
                        // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
                } catch (Exception ie) {
                        System.out.println("error at disaster backlist");
                } finally {

                        try {
                                con.close();
                        } catch (Exception ee) {
                        }
                }
                listF = list;
                loadtable1();



        }

        void loadtable1() {
                col_title.setCellValueFactory(new PropertyValueFactory<disaster, String>("Title"));
                col_type.setCellValueFactory(new PropertyValueFactory<disaster, String>("Type"));
                col_district.setCellValueFactory(new PropertyValueFactory<disaster, String>("District"));
                col_address.setCellValueFactory(new PropertyValueFactory<disaster, String>("Address"));
                col_id.setCellValueFactory(new PropertyValueFactory<disaster, Integer>("Id"));

                //table.setItems(list);
                //listF=list;
                table.setItems(listF);

        }



         public ObservableList<disaster> getdiasterList() {
                ObservableList<disaster> diasterlist1 = FXCollections.observableArrayList();


                return diasterlist1;
        }

        int indexM = -1;

        void loadtable() {
                col_title.setCellValueFactory(new PropertyValueFactory<disaster, String>("Title"));
                col_type.setCellValueFactory(new PropertyValueFactory<disaster, String>("Type"));
                col_district.setCellValueFactory(new PropertyValueFactory<disaster, String>("District"));
                col_address.setCellValueFactory(new PropertyValueFactory<disaster, String>("Address"));
                col_id.setCellValueFactory(new PropertyValueFactory<disaster, Integer>("Id"));

                //table.setItems(list);
                listF = ConnectionDb.getdiasterlist();
                table.setItems(listF);


        }


        @FXML
        void tableclick(MouseEvent event) {

            try {
                try {
                    System.out.println("hey ki khobor");
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(PostBox.Post.class.getResource("PostView.fxml"));
                    AnchorPane ap = fxmlLoader.load();
                    Post sadmin = fxmlLoader.getController();
                    //sadmin.set(username,role);


                    sadmin.set(username, role, table.getSelectionModel().getSelectedItem().getId(), pane1);
                    pane1.setCenter(ap);
                    Connection con = ConnectionDb.DBC();
                    try {
                        String sql = "SELECT * FROM notify Where username = ? and Postid = ?";
                        PreparedStatement preparedStatement = con.prepareStatement(sql);
                        preparedStatement.setString(1, username);
                        preparedStatement.setInt(2, table.getSelectionModel().getSelectedItem().getId());
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (!resultSet.next()) {
                            PreparedStatement ps1 = con.prepareStatement("insert into `notify`  (Username,Postid) values (?,?);");
                            // ResultSet rs1= ps1.executeQuery();
                            ps1.setString(1, username);
                            ps1.setInt(2, table.getSelectionModel().getSelectedItem().getId());
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
    Connection con=ConnectionDb.DBC();
    public  HomeboardController(){
        con=ConnectionDb.DBC();

    }
    String username;
    String role;

    public void set(String username, String role) {
        con=ConnectionDb.DBC();
       // user.setText(username);
       // rolee.setText("@" + role);
        this.role = role;
        this.username = username;
       // alertcount();
       // alertnum.setText(String.valueOf(newcount));
        //Thread t=new UserDashboardController.AlertThread();
        //t.start();
        // loadtable0();
    }public void set(String username, String role, BorderPane pane1) {
        this.pane1=pane1;
        con=ConnectionDb.DBC();
       // user.setText(username);
       // rolee.setText("@" + role);
        this.role = role;
        this.username = username;
       // alertcount();
       // alertnum.setText(String.valueOf(newcount));
        //Thread t=new UserDashboardController.AlertThread();
        //t.start();
        // loadtable0();
    }




        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            loadtable();
            ImageView imageView0 = new ImageView(new Image(new File("src/main/Font/search.png").toURI().toString()));
            imageView0.setFitHeight(20);
            imageView0.setFitWidth(25);
            btsearch.setGraphic(imageView0);
    }
}
