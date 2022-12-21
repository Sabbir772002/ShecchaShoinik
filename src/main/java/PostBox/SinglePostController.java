package PostBox;

import AdminDB.UserDashboardController;
import DB.ConnectionDb;
import com.example.sheccashoinik.disaster;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class SinglePostController implements Initializable {
    public void set(BorderPane pane){

        pane1=pane;
    }

    @FXML
    private Label Date;

    @FXML
    private Label District;

    @FXML
    private Label Title;

    @FXML
    private Label Type;

    @FXML
    private ImageView image;
    public String s;

    @FXML
    private VBox productBox;
    private Stage stage;
    private Parent root;
    int id=0;
    private String name;
    private String role;
    @FXML
    BorderPane pane1;

    @FXML
    void ViewPost(ActionEvent event) {
        try{
            try{
                System.out.println("hey ki khobor");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(PostBox.Post.class.getResource("PostView.fxml"));
                AnchorPane ap = fxmlLoader.load();
                PostBox.Post sadmin = fxmlLoader.getController();
                sadmin.set(name, role,id,pane1);
                pane1.setCenter(ap);
                System.out.println("kno holo na");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            //admin.set(name,role,id);
            Connection con=ConnectionDb.DBC();
            try{
                String sql = "SELECT * FROM notify Where username = ? and Postid = ?";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {
                        PreparedStatement ps1 = con.prepareStatement("insert into `notify`  (Username,Postid) values (?,?);");
                        // ResultSet rs1= ps1.executeQuery();
                        ps1.setString(1, name);
                        ps1.setInt(2,id);
                        ps1.execute();
                        ps1.close();
                        //rs1.close();
                    } else {;
                        System.out.println("ase aita");
                    }
                    resultSet.close();
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }

            }catch( Exception e ){
                System.out.println(e.getMessage());

            }
            /*stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("PostBox");
            stage.show();*/


        }catch (Exception e ){
            System.out.println(e.getMessage());
        }



    }
   public void loadtable0(UserDashboardController.post disaster, String name, String role) {
        this.name=name;
        this.role=role;
       Date.setText(disaster.getId()+"");
       Title.setText(disaster.getTitle()+" ");
       Type.setText(disaster.getType()+" ");
       District.setText(disaster.getDistrict()+" ");
       id=disaster.getId();
       try {


           File f = new File(disaster.getId() + ".png");
           FileOutputStream fos = new FileOutputStream(f);
           fos.write(disaster.getB());
           image.setImage(new Image(f.toURI().toString()));
       }catch (Exception e) {
           System.out.println("error");
       }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loadtable0();
    }
}
