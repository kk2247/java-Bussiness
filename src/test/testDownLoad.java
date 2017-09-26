package test;

import Dao.ConnectToMysql;
import Dao.DownLoad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDownLoad {
    public static void main(String[] args){
        ConnectToMysql connectToMysql=new ConnectToMysql("bussiness");
        try {
            Connection connection=connectToMysql.getConnection();
            String sql="select * from food where goodName = 12";
            System.out.println(sql);
            PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            int row=resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
            System.out.println(row);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
