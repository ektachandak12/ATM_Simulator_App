import java.sql.*;

public class Conn {
    public Connection connection;
    Connection c;
    Statement s;


    public Conn(){
        try{

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Ekta@1204");
            s = c.createStatement();


        } catch(Exception e){
            System.out.println(e);
        }
    }

}