package sample;

import Dao.ConnectToMysql;
import Dao.UpLoad;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import test.SentNewEmail;

import javax.mail.MessagingException;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class Register extends Window implements Initializable {
    private Stage stage=new Stage();
    private ConnectToMysql connect=new ConnectToMysql("bussiness");
    private UpLoad upLoad=new UpLoad(connect.getConnection());
    private SentNewEmail sentNewEmail=new SentNewEmail();
    private Account user;
    @FXML
    private TextField account;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TextField schoolID;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField authCode;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Button comfirm;
    @FXML
    private Button back;
    @FXML
    private Button buildNumber;
    @FXML
    private CheckBox vip;
    @FXML
    private ImageView picture;
    private String picturePath="";
    private InputStream accountPicture;
    private String number="";

    public Register() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void sentNumber() throws MessagingException {
        number="";
        Random random=new Random();
        for(int j=0;j<6;j++){
            number=number+random.nextInt(10);
        }
        buildNumber.setDisable(true);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            int i=60;
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String text = "距下次可发送时间" + i + "秒";
                        i--;
                        buildNumber.setText(text);
                        if(i<0)
                        {
                            timer.cancel();
                            buildNumber.setDisable(false);
                            buildNumber.setText("发送验证码到邮箱");
                        }
                    }
                });
            }
        }, 0,1000);
//        timer.scheduleAtFixedRate(new TimerTask() {
//            int i=60;
//            public void run() {
//                String text="距下次可发送时间"+i+"秒";
//                buildNumber.setText(text);
//                if(i<0){
//                    timer.cancel();
//                }
//            }
//        }, 0, 1000);
        sentNewEmail.sent(email.getText(),account.getText(),number);
    }
    public void setComfirm() throws IOException {
        if(account.getText().isEmpty()==false&&picturePath!=""&&name.getText().isEmpty()==false&&email.getText().isEmpty()==false&&schoolID.getText().isEmpty()==false
                &&phoneNumber.getText().isEmpty()==false&&authCode.getText().isEmpty()==false&&password.getText().isEmpty()==false&&password2.getText().isEmpty()==false){
            if(password2.getText().equals(password.getText())){
                if(authCode.getText().equals(number)){
                    accountPicture=new FileInputStream(picturePath);
                    if(vip.isSelected()==true){
                        user=new Account(name.getText(),Integer.valueOf(schoolID.getText()),account.getText(),password.getText(),true,phoneNumber.getText()
                        ,accountPicture,email.getText());
                    }else{
                        user=new Account(name.getText(),Integer.valueOf(schoolID.getText()),account.getText(),password.getText(),false,phoneNumber.getText()
                                ,accountPicture,email.getText());
                    }
                    upLoad.upLoadAccount(user);
                }
            }
        }
        Main.stageController.transStage(Main.Register,Main.LoginIn);
    }
    public void setPicture(){
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("选择图片");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("RMVB", "*.rmvb")
        );
        List<File> fileList=fileChooser.showOpenMultipleDialog(this);
        if(fileList==null){
        }else{
            picturePath=String.valueOf(fileList).substring(1,String.valueOf(fileList).length()-1);
            String fileName = "file:"+picturePath;
            Image newImage=new Image(fileName);
            picture.setImage(newImage);
        }
    }
    public void setBack(){
        Main.stageController.closeStage(Main.Register);
    }
}
