package BloodBank;

import DB.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class BloodBankController implements Initializable
{
    Connection con;
    String username="";
    String role="";

    public void set(String username, String role) {
        con = ConnectionDb.DBC();
        role = role;
        this.role = role;
        this.username = username;

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
    String bloodtype="";

        @FXML
        private Label BloodAvailableno;

        @FXML
        private AnchorPane Requestpane;

        @FXML
        private Button a0;

        @FXML
        private Button a1;


        @FXML
        private Button ab0;

        @FXML
        private Button ab1;

        @FXML
        private Button b0;

        @FXML
        private Button b1;

        @FXML
        private TableView<?> blooddonatorlist;

        @FXML
        private Button bombay;

        @FXML
        private DatePicker cbdate;

        @FXML
        private ComboBox<String> cbdis;

        @FXML
        private ComboBox<String> cbdiv;

        @FXML
        private ComboBox<String> cddiv;

        @FXML
        private Button claimbt;

        @FXML
        private AnchorPane claimpane;

        @FXML
        private TableColumn<User, String> colname;

        @FXML
        private TableColumn<User, String> colusername;

        @FXML
        private DatePicker date;

        @FXML
        private Button donatebt;

        @FXML
        private AnchorPane donatepane1;

        @FXML
        private AnchorPane donatorpane;

        @FXML
        private TextField hos;

        @FXML
        private TextField hospital;

        @FXML
        private Button o0;

        @FXML
        private Button o1;

        @FXML
        private Button request;

        @FXML
        private Button rh;
        @FXML
        private Label bdtype;

        @FXML
        void bloodselect(ActionEvent event) {
           bloodtype=((Button)event.getSource()).getText();
           // System.out.println(bloodtype);
            bdtype.setText(bloodtype);try {
                //String s="INSERT INTO bloodbank (Username,Type) VALUES(?,?);";
                String s1="select Type from bloodbank where Type='"+bloodtype+"' and Avail=true";
                PreparedStatement ps= con.prepareStatement(s1);
                //ps.setString()
                ResultSet rs = ps.executeQuery();
                //ps.executeQuery();
                int i=0;
                while(rs.next()) {
                    rs.getString(1);
                    i++;
                }
                rs.close();
                BloodAvailableno.setText(i+" BAG");
                System.out.println("ekhane asse");
            }catch (Exception e ){
                System.out.println(e.getMessage());

            }


        }

        @FXML
        void claim(ActionEvent event) {

        }



    @FXML
    void claimt(ActionEvent event) {
        claimpane.setVisible(true);
        donatepane1.setVisible(false);
        donatorpane.setVisible(false);
        Requestpane.setVisible(false);

    }

    @FXML
    void donate(ActionEvent event) {

    }

    @FXML
    void donatet(ActionEvent event) {
        claimpane.setVisible(false);
        donatepane1.setVisible(true);
        donatorpane.setVisible(false);
        Requestpane.setVisible(false);
    }

    @FXML
    void donatort(ActionEvent event) {
        claimpane.setVisible(false);
        donatepane1.setVisible(false);
        donatorpane.setVisible(true);
        Requestpane.setVisible(false);

    }

    @FXML
    void requestt(ActionEvent event) {
        claimpane.setVisible(false);
        donatepane1.setVisible(false);
        donatorpane.setVisible(false);
        Requestpane.setVisible(true);

    }




        @FXML
        void selectforblood(ActionEvent event) {

        }

        @FXML
        void type(ActionEvent event) {

        }
    @FXML
    void Select(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdiv.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            cbdis.getItems().removeAll(cbdis.getItems());
            String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
            cbdis.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Chattogram")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Barishal")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Sylhet")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Sylhet","Habiganj","Moulvibazar","Sunamganj" };
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Mymensingh")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Mymensingh","Jamalpur","Netrokona","Sherpur" };
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Khulna")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Rangpur")){
            cbdis.getItems().removeAll(cbdis.getItems());

            String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
            cbdis.getItems().addAll(ditrict);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String []division={"Dhaka","Rajshahi","Chattogram","Barishal","Rangpur","Sylhet","Khulna", "Mymensingh"};

    }
}
