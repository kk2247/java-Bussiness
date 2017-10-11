package Dao;
import sample.Account;
import sample.Food;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class DownLoad {
    private Connection connection;

    public DownLoad(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Food> downLoadAllOfFoodByTimes(String table){
        ArrayList<Food>foods=new ArrayList<Food>();
        Food food = null;
        String sql="select * from "+table+" ORDER by times";
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            int row=resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                if(row==11) {
                    food = new Food(resultSet.getString(3), resultSet.getFloat(6),resultSet.getString(1),
                            Integer.valueOf(resultSet.getString(2)),
                            resultSet.getInt(5), resultSet.getString(9), resultSet.getString(10)
                            , resultSet.getString(7),resultSet.getBinaryStream(8));
                    foods.add(food);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public Account downloadUser(String account,String password){
        Account person;
        try {
            if(account.isEmpty()==false&&account.length()<20) {
                String sql="select * from person where account='"+account+"'";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                resultSet.next();
                if(password.equals(resultSet.getString(3))){
                    person=new Account(resultSet.getString(1),Integer.valueOf(resultSet.getString(4)),resultSet.getString(2),
                            resultSet.getString(3),resultSet.getBoolean(5),resultSet.getString(7),resultSet.getBinaryStream(6),
                            resultSet.getString(8));
                    System.out.println("登录成功");
                    return person;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
