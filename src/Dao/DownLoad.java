package Dao;
import sample.Food;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class DownLoad {
    private Connection connection;

    public DownLoad(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Food> downLoadAllOfFood(String table){
        ArrayList<Food>foods=new ArrayList<Food>();
        Food food = null;
        InputStream inputStream = null;
        String sql="select * from "+table;
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            int row=resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                if(row==10) {
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
}
