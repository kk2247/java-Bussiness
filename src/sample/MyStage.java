package sample;

import javafx.stage.Stage;

import java.util.ArrayList;

public class MyStage {
    private Stage stage;
    private String name;
    private ArrayList<String> datas=new ArrayList<String>();

    public ArrayList<String> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<String> datas) {
        this.datas = datas;
    }

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
}