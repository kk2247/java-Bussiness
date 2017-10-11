package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStage {
    private Stage stage;
    private String name;
    private Account account;
    private Scene scene;
    public MyStage(Stage stage, String name) {
        this.stage = stage;
        this.name = name;
    }

    public MyStage(Stage stage, String name, Scene scene) {
        this.stage = stage;
        this.name = name;
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
