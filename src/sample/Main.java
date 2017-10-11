package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Account person=new Account();
    public static StageController stageController=new StageController();

    public static String LoginIn="loginIn";
    public static String LoginInRes="LoginIn.fxml";

    public static String AddFood="addFood";
    public static String AddFoodRes="AddFood.fxml";

    public static String Register="register";
    public static String RegisterRes="Register.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        stageController.loadStage(LoginIn,LoginInRes);
        //stageController.loadStage(AddFood,AddFoodRes);
        //stageController.loadStage(Register,RegisterRes);
        stageController.transStage(LoginIn);
    }
//    public void setAccount(Account account){
//        person=account;
//    }
//    public Account getAccount(){
//        return person;
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
