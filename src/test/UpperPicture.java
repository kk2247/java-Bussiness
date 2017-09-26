package test;

import Dao.ConnectToMysql;
import com.mysql.jdbc.PreparedStatement;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/*
name     VARCHAR(120) NOT NULL
  COMMENT '出售者姓名',
  schoolID VARCHAR(120) NOT NULL
  COMMENT '出售者学号',
  goodName VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  goodID BIGINT NOT NULL AUTO_INCREMENT
    COMMENT '商品ID',
  goodNumber INT NOT NULL
  COMMENT '商品数量',
  goodPrice FLOAT NOT NULL
  COMMENT '商品价格',
  goodDescribe VARCHAR(500) NOT NULL
  COMMENT '商品描述',
  goodPicture BLOB
  COMMENT '商品图片',
 */
public class UpperPicture {
    static ConnectToMysql connect=new ConnectToMysql("bussiness");
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Connection connection=connect.getConnection();
        File file=new File("D:\\图片\\和泉纱雾\\1ffae8fb57886fa74e1d38140fe638d3.jpg");
        byte[] by = new byte[(int) file.length()];
        InputStream inputStream=new FileInputStream(file);
        Float number=Float.valueOf(100);
        String str="insert person(name,account,password,schoolID,vip)values('adasd','adaa','sada','asdasd',false)";
        String string="insert good (name,schoolID,goodName,goodID,goodNumber,goodPrice,goodDescribe,goodPicture,produceTime)values('asa',12121,'fasf',4544547,?,100,'sdfs',? ,'2012-01-01')";
        PreparedStatement preparedStatement=(PreparedStatement)connection.prepareStatement(string);
        preparedStatement.setFloat(1,number);
        preparedStatement.setBinaryStream(2, inputStream, inputStream.available());
        System.out.println(string);
        preparedStatement.executeUpdate();
        inputStream.close();
    }
}
