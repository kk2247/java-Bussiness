package Dao;

import sample.Account;
import sample.Food;
import sample.Goods;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpLoad {
    private Connection connection;

    public UpLoad(Connection connection) {
        this.connection = connection;
    }

    public boolean uploadFood(Food food) throws IOException, SQLException, ClassNotFoundException {
//        File file=new File(picturePath);
//        InputStream inputStream=new FileInputStream(file);
        String sql="insert good (name,schoolID,goodName,goodNumber,goodPrice,goodDescribe,produceTime,endTime,goodPicture)values('"+food.getOwnerName()+"',"+food.getOwnerSchoolID()+",'"
                +food.getName()+"',"+food.getNumber()+","+food.getPrice()+",'"+food.getDescribe()+"','"+food.getProduceDay()+"','"+food.getDeadLine()+"',? )";
        PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
        preparedStatement.setBinaryStream(1,food.getFoodPicture(),food.getFoodPicture().available());
        System.out.println(sql);
        preparedStatement.executeUpdate();
        return true;
    }
}
