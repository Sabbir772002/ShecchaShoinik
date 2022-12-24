package BloodBank;

import Chat.userlist;
import DB.ConnectionDb;
import Others.Team;
import com.example.sheccashoinik.disaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Optional;
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
        //showDonator();

        // alertcount();
        //alertnum.setText(String.valueOf(newcount));
        // Thread t=new HelpRequest.AlertThread();
        //t.start();


    }
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
    private TextField bag;

    @FXML
    private Label bdtype;

    @FXML
    private TableView<User> blooddonatorlist;

    @FXML
    private Button bombay;

    @FXML
    private ComboBox<String> cbdis;

    @FXML
    private ComboBox<String> cbdisc;

    @FXML
    private ComboBox<String > cbdisr;

    @FXML
    private ComboBox<String> cbdivc;

    @FXML
    private ComboBox<String > cbdivd;

    @FXML
    private ComboBox<String > cbdivr;

    @FXML
    private Button claimbt;

    @FXML
    private AnchorPane claimpane;

    @FXML
    private TableColumn<User, String > colname;

    @FXML
    private TableColumn<User, String > colusername;

    @FXML
    private DatePicker dated;

    @FXML
    private DatePicker dater;

    @FXML
    private Button donatebt;

    @FXML
    private AnchorPane donatepane1;

    @FXML
    private AnchorPane donatorpane;

    @FXML
    private TextField hosc;

    @FXML
    private TextField hosd;

    @FXML
    private TextField hosr;

    @FXML
    private Button o0;

    @FXML
    private Button o1;

    @FXML
    private TextField reason;

    @FXML
    private Button request;

    @FXML
    private Button rh;
    @FXML
    private TextField  search;;
    @FXML
    void keyclick(KeyEvent e) {
        ObservableList<User> list1 = FXCollections.observableArrayList();
        //i++;


        Connection con ;
        //= ConnectionDb.DBC();
        //ObservableList<diaster>list = FXCollections.observableArrayList();
        try {

            con = ConnectionDb.DBC();
            String s = "Select Name,Username,LastTime from userlist";
            try {
                // System.out.println("hlw");
                PreparedStatement ps = con.prepareStatement(s);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String s1 = rs.getString(1);
                    String s3 = rs.getString(2);
                    String s5 = rs.getString(3);
                    //System.out.println(s5);
                    if (check(s5) || s5.equals(null)) {
                        String s0=s1+s3;

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
                            list1.add(new User(s1, s3));                        }

                    }
                }
                // rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7))
            } catch (Exception ie) {
                System.out.println("error at bank serch user backlist"+ie.getMessage());
            } finally {

                try {
                   // con.close();
                } catch (Exception ee) {
                }
            }
            colname.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
            colusername.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
            blooddonatorlist.setItems(list1);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    ObservableList<User> list = FXCollections.observableArrayList();
    ObservableList<User> loaddonator() {
        con=ConnectionDb.DBC();
        String s = "Select Name,Username,LastTime from userlist";
        try
        {
           // System.out.println("hlw");
            PreparedStatement ps=con.prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

                String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s5=rs.getString(3);
                System.out.println(s5);
                if(check((s5))||s5.equals(null)) {
                   // list.add(new User(rs.getString(1), rs.getString(2)));
                    list.add(new User(s1, s2));
                }

            }
            ps.close();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


return list;

    }
    void showDonator(){
        colname.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        colusername.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));

        list =loaddonator();
        blooddonatorlist.setItems(list);



    }
void showDonators(){
        colname.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        colusername.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));

        blooddonatorlist.setItems(list);



    }


    @FXML
    void cbdisd(ActionEvent event) {

    }




    @FXML
    void usergo(MouseEvent event) {

    }

        boolean check(String d) throws ParseException {
           /* String Date1=  "20/12/2022";
            String Date2=  "24/07/2022";*/
           /* Date d1 = null;
            Date d2 = null;
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String str = format.format(date);
            String str2 = format.format(d);
            d1 = format.parse(str2);
            d2 = format.parse(str);
            long diff = d2.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            System.out.print(diffDays + " days, ");
            if(diffDays>=90 ){
             return true;
         }else{
             return false;
         }*/

            long millis=System.currentTimeMillis();

            // creating a new object of the class Date
            java.sql.Date date = new java.sql.Date(millis);
            LocalDate startDate = LocalDate.parse(d);

            // End date
            LocalDate endDate = LocalDate.parse(date.toString());
            //System.out.println("Hey"+date.toString());
            Period period = Period.between(startDate, endDate);
            if(period.getMonths()>=3||period.getYears()>0){
                return true;
            }else{
                return false;
            }
        }
        String bloodtype;

        @FXML
        void bloodselect(ActionEvent event) {
           bloodtype=((Button)event.getSource()).getText();
           // System.out.println(bloodtype);
            bdtype.setText(bloodtype);
            try {
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
 void bloodselect() {
          // bloodtype=((Button)event.getSource()).getText();
           // System.out.println(bloodtype);
            bdtype.setText(bloodtype);
            try {
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
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String str = format.format(date);
        try {
            if (bloodtype.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Blood Type Warning!");
                alert.setHeaderText("Please Select Your BloodGroup First!");
                // alert.setContentText("");
                File file = new File("src/main/Font/icon1.png");
                Optional<ButtonType> result=alert.showAndWait();
                return;
            } else {
                //String s="INSERT INTO bloodbank (Username,Type) VALUES(?,?);";
                String s1 = "Insert into bloodbank (Username,Type,Avail,Hospital,Division,District) Values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(s1);
                ps.setString(1, username);
                ps.setString(2, bloodtype);
                ps.setInt(3, 1);
                ps.setString(4, hosd.getText().toString());
                ps.setString(5, cbdivd.getValue().toString());
                ps.setString(6, cbdis.getValue().toString());

                ps.execute();
                String s2 = "UPDATE userlist set LastTime='" + dated.getValue().toString() + "' where username='" + username + "'";
                ps = con.prepareStatement(s2);
                ps.execute();
                ps.close();
                System.out.println("rokto jog hoise");
            }
            }catch(Exception ee ){
                System.out.println(ee.getMessage());

            }
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
    void selectc(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdivc.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            cbdisc.getItems().removeAll(cbdisc.getItems());
            String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
            cbdisc.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
            cbdisc.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Chattogram")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
            cbdisc.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Barishal")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
            cbdisc.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Sylhet")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Sylhet","Habiganj","Moulvibazar","Sunamganj" };
            cbdisc.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Mymensingh")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Mymensingh","Jamalpur","Netrokona","Sherpur" };
            cbdis.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Khulna")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
            cbdisc.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Rangpur")){
            cbdisc.getItems().removeAll(cbdisc.getItems());

            String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
            cbdisc.getItems().addAll(ditrict);
        }
    }@FXML
    void selectr(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdivr.getSelectionModel().getSelectedItem().toString();
        }catch(Exception e ){
            divisionname="";
        }
        if(divisionname.equals("Dhaka")){
            cbdisr.getItems().removeAll(cbdisr.getItems());
            String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
            cbdis.getItems().addAll(ditrict);
        }else if(divisionname.equals("Rajshahi")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Rajshahi","Sirajgonj","Bogra","Chapinawabganj","Joypurhat","Naogaon","Natore","Pabna"};
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Chattogram")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Chattogram","Cox's Bazar", "Rangamati", "Bandarban", "Khagrachhari", "Feni", "Lakshmipur", "Comilla"," Noakhali", "Brahmanbaria" ,"Chandpur"};
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Barishal")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Barishal", "Barguna", "Bhola", "Jhalokati", "Pirojpur","Patuakhali"};
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Sylhet")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Sylhet","Habiganj","Moulvibazar","Sunamganj" };
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Mymensingh")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Mymensingh","Jamalpur","Netrokona","Sherpur" };
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Khulna")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Khulna","Bagherhat","Chuadanga","Jessore","Jinaidaha","Magura","Meherpur","Narail","Satkhira" };
            cbdisr.getItems().addAll(ditrict);
        }
        else if(divisionname.equals("Rangpur")){
            cbdisr.getItems().removeAll(cbdisr.getItems());

            String []ditrict={"Rangpur","Kurigram","Gaibandha","Thakurgaon","Dinajpur","Nilphamari","Panchagarh","Lalmonirhat" };
            cbdisr.getItems().addAll(ditrict);
        }
    }@FXML
    void selectd(ActionEvent event) {
        String divisionname;
        try{
            divisionname=cbdivd.getSelectionModel().getSelectedItem().toString();
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
        cbdivc.getItems().addAll(division);
        cbdivc.getSelectionModel().select(0);cbdivr.getItems().addAll(division);
        cbdivd.getSelectionModel().select(0);cbdivd.getItems().addAll(division);
        cbdivd.getSelectionModel().select(0);

        String []ditrict={"Dhaka","Gazipur","Faridpur","Gopalganj","Jamalpur","Kishoreganj","Madaripur","Manikganj","Munshiganj","Narayanganj","Narshingdi","Rajbari","Shariatpur","Tangail"};
         cbdis.getItems().addAll(ditrict);
         cbdisc.getItems().addAll(ditrict);
         cbdisr.getItems().addAll(ditrict);
        cbdis.getSelectionModel().select(0);
        cbdisc.getSelectionModel().select(0);
        cbdisr.getSelectionModel().select(0);
        bloodtype="A+";
        con=ConnectionDb.DBC();
        bloodselect();
        showDonator();

    }

}
