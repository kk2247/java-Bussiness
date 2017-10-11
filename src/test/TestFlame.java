package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class TestFlame extends Application{
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Stage stage = new Stage();
        Group group = new Group();
        stage.setTitle("Example");
        stage.setScene(new Scene(group, 300, 275));
        stage.show();

        Button button0 = new Button("button0");
        Button button1 = new Button("button1");
        group.getChildren().addAll(button0, button1);

        //注意，高潮来了
        button0.layoutXProperty().bind(stage.widthProperty().multiply(2).divide(3));
        button0.layoutYProperty().bind(stage.heightProperty().multiply(2).divide(3));
        button0.prefWidthProperty().bind(stage.widthProperty().multiply(.1));

        button1.layoutXProperty().bind(stage.widthProperty().multiply(1).divide(3));
        button1.layoutYProperty().bind(stage.heightProperty().multiply(2).divide(3));
        button1.prefWidthProperty().bind(stage.widthProperty().multiply(.1));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//        JFrame frame=new JFrame();
//        JPanel jp=new JPanel();
//        frame.setContentPane(jp);
//        jp.setLayout(new GridLayout());
//        frame.setLocation(800,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800,500);
//        frame.setVisible(true);
//
//        JPanel panel=new JPanel();
//        panel.setSize(200,100);
//        panel.setBackground(yellow);
//        jp.add(panel);
//
//
//        JPanel panel1=new JPanel();
//        panel1.setSize(200,100);
//        panel1.setBackground(blue);
//        jp.add(panel1);

//        panel1.setLocation(400,250);
