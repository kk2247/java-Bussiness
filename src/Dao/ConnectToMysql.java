package Dao;

import java.sql.*;

public class ConnectToMysql {
    private String driver = "com.mysql.jdbc.Driver";
    private String url;
    private String user = "root";
    private String password = "855976";
    public ConnectToMysql(String database) {
        url= "jdbc:mysql://localhost:3306/"+database;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed()) {
            System.out.println("Succeeded connecting to the Database!");
            return con;
        }
        return null;
    }
}
