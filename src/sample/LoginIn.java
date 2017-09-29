package sample;

import Dao.ConnectToMysql;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginIn implements Initializable,Menus{
    public Account person;
    private ConnectToMysql connect=new ConnectToMysql("bussiness");
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Button comfirm;
    @FXML
    private Button clear;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setComfirm(){
        try {
            Connection connection=connect.getConnection();
            if(account.getText().isEmpty()==false&&account.getText().length()<20) {
                String sql="select * from person where account='"+account.getText()+"'";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                resultSet.next();
                if(password.getText().equals(resultSet.getString(3))){
                    person=new Account(resultSet.getString(1),Integer.valueOf(resultSet.getString(4)),resultSet.getString(2),
                            resultSet.getString(3),resultSet.getBoolean(5),resultSet.getString(7),resultSet.getBinaryStream(6),
                    resultSet.getString(8));
                    System.out.println("登录成功");

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setClear(){
        account.setText("");
        password.setText("");
    }
    @FXML
    private Button register;
    public void setRegister() throws IOException {
        Main.stageController.transStage(Main.Register);
    }

    @Override
    public void setQuit() {
        System.exit(0);
    }

    @Override
    public void setReleaseGoods() {

    }

    @Override
    public void setCheckGoods() {

    }

    @Override
    public void setSearchGoods() {

    }

    @Override
    public void setFillInformation() {

    }

    @Override
    public void setCheckInformation() {

    }

    @Override
    public void setAbout() {

    }

    @Override
    public void setVIP() {

    }

    @Override
    public void setLoginIn() {

    }

    @Override
    public void setAsVip() {

    }

    @Override
    public void setLoginOut() {

    }

    @Override
    public void setReleaseOldGoods() {

    }

    @Override
    public void setCheckOldGoods() {

    }

    @Override
    public void setSearchOldGoods() {

    }
}
