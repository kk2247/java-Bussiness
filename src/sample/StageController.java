package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class StageController implements Initializable {
    private ArrayList<MyStage> arrayList=new ArrayList<MyStage>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void loadStage(String stageName,String source) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(source));
        stage.setTitle("Hello World");
        Scene scene=new Scene(root);
        stage.setScene(scene);
        scene.setFill(null);
        stage.initStyle(StageStyle.TRANSPARENT);
        arrayList.add(new MyStage(stage,stageName));
    }
    public void transStage(String close,String open) throws IOException {
        Iterator<MyStage> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            MyStage myStage=iterator.next();
            if(myStage.getName().equals(close)){
                myStage.getStage().close();
            }
            if (myStage.getName().equals(open)){
                myStage.getStage().show();
            }
        }
    }
    public void transStage(String open) throws IOException {
        Iterator<MyStage> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            MyStage myStage=iterator.next();
            if (myStage.getName().equals(open)){
                myStage.getStage().show();
            }
        }
    }
    public void storeDatas(String stageName,String data){
        Iterator<MyStage> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            MyStage myStage=iterator.next();
            if (myStage.getName().equals(stageName)){
                myStage.getDatas().add(data);
            }
        }
    }
    public String readDatas(String stageName,int count){
        Iterator<MyStage> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            MyStage myStage=iterator.next();
            if (myStage.getName().equals(stageName)){
                return myStage.getDatas().get(count);
            }
        }
        return null;
    }
}
