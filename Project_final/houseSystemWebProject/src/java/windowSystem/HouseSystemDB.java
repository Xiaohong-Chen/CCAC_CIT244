package windowSystem;

import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Creating an database that was deployed in AWS to store weather information 
 * and house window system information
 */
@ManagedBean(eager = true)
@SessionScoped
public class HouseSystemDB implements Serializable{
    //Setting the URL, USER, PASSWORD of the database    
    private final String URL = "jdbc:mysql://mydb.c7dqzvdqwufu.us-east-2.rds.amazonaws.com:3306";
    private final String user = "mydb";
    private final String password = "123456789";
    //Declaring an Connection
    private Connection con;
    
    //Getting an Connection
    public Connection getDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, user, password);
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
            return null;
        } catch (SQLException ex) {
            System.out.println("SQLException");
            return null;
        }
    }
    
    //Close the database
    public void disconnectDB() throws SQLException {
        con.close();
    }
}
