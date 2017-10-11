package sample;

import Dao.ConnectToMysql;
import Dao.DownLoad;
import Dao.UpLoad;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import jdk.internal.util.xml.impl.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class AddFood extends Window implements Initializable,Menus{
    private Stage stage=new Stage();
    private Food food;
    private InputStream inputStream;
    private String picturePath="";
    private ConnectToMysql connectToMysql=new ConnectToMysql("bussiness");
    private UpLoad upLoadFood=new UpLoad(connectToMysql.getConnection());
    @FXML
    private ImageView userPicture;
    @FXML
    private Label userName;
    @FXML
    private Label userSchoolID;
    private void setTitle(){
        userPicture.setImage(new Image(Main.person.getPicture()));
        userName.setText("姓名："+Main.person.getName());
        userSchoolID.setText("学号："+Main.person.getSchoolID());
    }
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button submit;

    @FXML
    private ImageView image;

    @FXML
    private Button clear;



    @FXML
    private MenuItem quit;

    public AddFood() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setStyle("-fx-background-color: rgba(100,150,255,0.5);");
        image.setImage(new Image("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1505636368&di=7cd271d197f5406838853b1f19eaa180&src=http://img.dongman.fm/public/ae58bff4102b0cd7cb3cb69070e0c38f.jpg"));
        if(Main.person==null){
            System.out.println(1);
        }else{
            setTitle();
        }
        //setTree();

    }
    public void setImage() throws IOException {
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
            image.setImage(newImage);
//            Main.stageController.storeDatas(Main.stage1Name,fileName);
        }
    }
    @FXML
    private TextField foodName;

    @FXML
    private TextField foodPrice;

    @FXML
    private TextField foodNumber;

    @FXML
    private TextField foodExpiration;

    @FXML
    private TextField foodDescribe;

    @FXML
    private TextField foodYear;

    @FXML
    private TextField foodMonth;

    @FXML
    private TextField foodDay;
    public boolean setSubmit() throws IOException, SQLException, ClassNotFoundException {
        if(picturePath!="") {
            inputStream = new FileInputStream(new File(picturePath));
        }else{
            return false;
        }
        Calendar calendar=Calendar.getInstance();
        int year;
        int month;
        calendar.set(Integer.valueOf(foodYear.getText()),Integer.valueOf(foodMonth.getText()),Integer.valueOf(foodDay.getText()));
        if(calendar.get(Calendar.MONTH)==0){
            month=12;
            year=calendar.get(Calendar.YEAR)-1;
        }else{
            month=calendar.get(Calendar.MONTH);
        }
        String produceDay=calendar.get(Calendar.YEAR)+"-"+month+"-"+calendar.get(Calendar.DATE);
        calendar.add(Calendar.MONTH, Integer.parseInt(foodExpiration.getText()));
        if(calendar.get(Calendar.MONTH)==0){
            month=12;
            year=calendar.get(Calendar.YEAR)-1;
        }else{
            month=calendar.get(Calendar.MONTH);
        }
        String deadline=calendar.get(Calendar.YEAR)+"-"+month+"-"+calendar.get(Calendar.DATE);
        if(foodName.getText().isEmpty()||foodPrice.getText().isEmpty()||foodNumber.getText().isEmpty()||foodExpiration.getText().isEmpty()||foodDescribe.getText().isEmpty()||foodYear.getText().isEmpty()
                ||foodMonth.getText().isEmpty()||foodDay.getText().isEmpty()){
            inputStream.close();
            return false;
        }else{
            food=new Food(foodName.getText(),Float.valueOf(foodPrice.getText()),Main.person.getName(),Main.person.getSchoolID(),Integer.valueOf(foodNumber.getText()),produceDay,deadline,foodDescribe.getText(),inputStream);
            System.out.println(food.toString()+food.getName()+food.getPrice());
            upLoadFood.uploadFood(food);
            inputStream.close();
            return true;
        }
    }
    public void setClear(){

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
    @FXML
    private TreeTableColumn type;
    @FXML
    private TreeView<String> view;
    @FXML
    private Button button;
    public void setTree(){
//        TreeTableColumn<String,String> treeTableColumn=new TreeTableColumn<>("商品");
//        treeTableColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
//                new ReadOnlyStringWrapper(p.getValue().getValue()));
        TreeItem<String> rootItem = new TreeItem<> ("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<> ("Message" + i);
            rootItem.getChildren().add(item);
        }
        view= new TreeView<> (rootItem);

    }
}
