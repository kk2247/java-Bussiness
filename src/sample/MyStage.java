package sample;

import javafx.stage.Stage;

import java.util.ArrayList;

public class MyStage {
    private Stage stage;
    private String name;
    private Account account;
    public MyStage(Stage stage, String name) {
        this.stage = stage;
        this.name = name;
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
