package Chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author : Kavishka Prabath
 * @since : 0.1.0
 **/

public class UserWrite extends Thread {

    private ArrayList<UserWrite> clients;

    private Socket socket;

    public BufferedReader in;

    public PrintWriter writer;

    public UserWrite(Socket socket, ArrayList<UserWrite> clients) throws IOException {
        this.clients=clients;
        this.socket=socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }
    ArrayList<String> ar=new ArrayList<String>();
    ArrayList<String> list(){
        ar.add("Sabbir");
        ar.add("Sumon");
        ar.add("Alif");
        ar.add("Rafi");
        return ar;
    }
    @Override
    public void run(){
        try {
            String msg;
            while ((msg = in.readLine()) != null) {
                if (msg.equalsIgnoreCase( "exit")) {
                    break;
                }

                for (UserWrite cl : clients) {
                    cl.writer.println(msg);
                    System.out.println(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

   /* private ArrayList<UserWrite> clients;

    private Socket socket;

    public BufferedReader in;

    public PrintWriter writer;
    public ObjectOutputStream op;
    public ObjectInputStream ip;

    public UserWrite(Socket socket, ArrayList<UserWrite> clients) throws IOException {
        this.clients=clients;
        this.socket=socket;
       this.op = new ObjectOutputStream(socket.getOutputStream());
        this.ip= new ObjectInputStream(socket.getInputStream());
     //   this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       // this.writer = new PrintWriter(socket.getOutputStream(), true);
        list();
    }
    ArrayList<Person> ar=new ArrayList<Person>();
    ArrayList<Person> list(){
        ar.add(new Person("Sabbir","22"));
        ar.add(new Person("Boss","20"));
        return ar;
    }
    @Override
    public void run(){
        try {
            String msg=(String)ip.readObject();
            while (true) {
                if (ip.readObject()!=null) {
                    break;
                }
           *//*     if (((String)(ip.readObject())).equalsIgnoreCase( "ar")) {
                    for (UserWrite cl : clients) {
                        //cl.writer.println(name());
                        System.out.println("array" + ar);
                      cl.op.writeObject(ar);
                        op.flush();
                        // System.out.println(msg);
                    }
                }else{*//*
                        for (UserWrite cl : clients) {
                            //cl.writer.println(name());
                            System.out.println("name"+name());
                            cl.op.writeObject(ar);
                            op.flush();

                    }
              //  }
           *//*     }else {
                    for (UserWrite cl : clients) {
                        cl.writer.println(msg);
                        System.out.println(msg);
                    }
                }*//*
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                //in.close();
              //  op.close();
              //  writer.close();
               // socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   // String name(){
/
        return "I am boss of yours";
    }

}
*/