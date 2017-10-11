package Dao;

import sample.Account;
import sample.Food;

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
        String sql="insert food (name,schoolID,goodName,goodNumber,goodPrice,goodDescribe,produceTime,endTime,goodPicture)values('"+food.getOwnerName()+"',"+food.getOwnerSchoolID()+",'"
                +food.getName()+"',"+food.getNumber()+","+food.getPrice()+",'"+food.getDescribe()+"','"+food.getProduceDay()+"','"+food.getDeadLine()+"',? )";
        PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
        preparedStatement.setBinaryStream(1,food.getFoodPicture(),food.getFoodPicture().available());
        preparedStatement.executeUpdate();
        return true;
    }
    public boolean upLoadAccount(Account account){
        String sql="insert person (name,schoolID,account,password,vip,picture,phoneNumber,email)values('"+account.getName()+"',"+account.getSchoolID()+
                ",'"+account.getAccount()+"','"+account.getPassword()+"',"+account.isVip()+",?,"+account.getPhoneNumber()+",'"+
                account.getEmail()+"')";
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setBinaryStream(1,account.getPicture(),account.getPicture().available());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("succeed!!!");
        return true;
    }
}
