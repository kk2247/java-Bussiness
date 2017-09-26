package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static StageController stageController=new StageController();

    public static String stage1Name="addFood";
    public static String stage1="AddFood.fxml";

    public static String stage2Name="stage2";
    public static String stage2="sample.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        stageController.loadStage(stage1Name,stage1);
        stageController.loadStage(stage2Name,stage2);
        stageController.transStage(stage1Name);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
