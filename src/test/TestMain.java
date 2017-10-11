package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage=new Stage();
        Group group=new Group();
        Scene scene=new Scene(group,600,400);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();

        Label[] labels=new Label[10];
        for(int i=0;i<10;i++){
//            labels[i].setText("12");

            group.getChildren().add(labels[i]);
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}
