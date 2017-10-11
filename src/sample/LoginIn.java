package sample;

import Dao.ConnectToMysql;
import Dao.DownLoad;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LoginIn implements Initializable,Menus{
    private ConnectToMysql connect=new ConnectToMysql("bussiness");
    DownLoad downLoad=new DownLoad(connect.getConnection());
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Button comfirm;
    @FXML
    private Button clear;

    public LoginIn() throws SQLException, ClassNotFoundException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
    public void setComfirm() throws IOException {
        if(account.getText().isEmpty()==false&&account.getText().length()<20) {
            Main.person=downLoad.downloadUser(account.getText(), password.getText());
            if(Main.person!=null){
                Main.stageController.loadStage(Main.AddFood,Main.AddFoodRes);
                Main.stageController.transStage(Main.LoginIn,Main.AddFood);
            }
        }
    }
    public void setClear(){
        account.setText("");
        password.setText("");
    }
    @FXML
    private Button register;
    public void setRegister() throws IOException {
        Main.stageController.loadStage(Main.Register,Main.RegisterRes);
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
    public void init(){
        ArrayList<Food> foods=downLoad.downLoadAllOfFoodByTimes("food");
        Iterator<Food> iter=foods.iterator();
        System.out.println(foods.size());
        switch (foods.size()){

            case 1:{
                show1(iter.next());
                break;
            }
            case 5:{
                show1(iter.next());
                show2(iter.next());
                show3(iter.next());
                show4(iter.next());
                show5(iter.next());
                break;
            }
        }
    }

    @FXML
    private VBox showBoard1;
    @FXML
    private ImageView goodPicture1;
    @FXML
    private Label price1;
    @FXML
    private Label number1;
    @FXML
    private Label schoolID1;
    @FXML
    private Label describe1;
    private void show1(Food food){
        goodPicture1.setImage(new Image(food.getFoodPicture()));
        price1.setText("价格"+String.valueOf(food.getPrice()));
        number1.setText("数量"+String.valueOf(food.getNumber()));
        schoolID1.setText("出售者学号"+String.valueOf(food.getOwnerSchoolID()));
        describe1.setText("描述"+food.getDescribe());
    }

    @FXML
    private VBox showBoard2;
    @FXML
    private ImageView goodPicture2;
    @FXML
    private Label price2;
    @FXML
    private Label number2;
    @FXML
    private Label schoolID2;
    @FXML
    private Label describe2;
    private void show2(Food food){
        goodPicture2.setImage(new Image(food.getFoodPicture()));
        price2.setText("价格:"+String.valueOf(food.getPrice()));
        number2.setText("数量:"+String.valueOf(food.getNumber()));
        schoolID2.setText("出售者学号:"+String.valueOf(food.getOwnerSchoolID()));
        describe2.setText("描述:"+food.getDescribe());
    }

    @FXML
    private VBox showBoard3;
    @FXML
    private ImageView goodPicture3;
    @FXML
    private Label price3;
    @FXML
    private Label number3;
    @FXML
    private Label schoolID3;
    @FXML
    private Label describe3;
    private void show3(Food food){
        goodPicture3.setImage(new Image(food.getFoodPicture()));
        price3.setText("价格:"+String.valueOf(food.getPrice()));
        number3.setText("数量:"+String.valueOf(food.getNumber()));
        schoolID3.setText("出售者学号:"+String.valueOf(food.getOwnerSchoolID()));
        describe3.setText("描述:"+food.getDescribe());
    }

    @FXML
    private VBox showBoard4;
    @FXML
    private ImageView goodPicture4;
    @FXML
    private Label price4;
    @FXML
    private Label number4;
    @FXML
    private Label schoolID4;
    @FXML
    private Label describe4;
    private void show4(Food food){
        goodPicture4.setImage(new Image(food.getFoodPicture()));
        price4.setText("价格:"+String.valueOf(food.getPrice()));
        number4.setText("数量:"+String.valueOf(food.getNumber()));
        schoolID4.setText("出售者学号:"+String.valueOf(food.getOwnerSchoolID()));
        describe4.setText("描述:"+food.getDescribe());
    }

    @FXML
    private VBox showBoard5;
    @FXML
    private ImageView goodPicture5;
    @FXML
    private Label price5;
    @FXML
    private Label number5;
    @FXML
    private Label schoolID5;
    @FXML
    private Label describe5;
    private void show5(Food food){
        goodPicture5.setImage(new Image(food.getFoodPicture()));
        price5.setText("价格:"+String.valueOf(food.getPrice()));
        number5.setText("数量:"+String.valueOf(food.getNumber()));
        schoolID5.setText("出售者学号:"+String.valueOf(food.getOwnerSchoolID()));
        describe5.setText("描述:"+food.getDescribe());
    }

}
