package hoursesystem;

import java.sql.*;

public class HouseSystemDB {

    private final String URL = "jdbc:mysql://mydb.c7dqzvdqwufu.us-east-2.rds.amazonaws.com:3306";
    private final String user = "mydb";
    private final String password = "123456789";

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(URL, user, password);

        return con;
    }

    public void disconnectDB() throws SQLException {
        con.close();
    }
}
