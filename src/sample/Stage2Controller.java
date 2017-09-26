package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Stage2Controller implements Initializable {
    @FXML
    private ImageView image;
    @FXML
    private Button button;
    @Override

    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setImage(){
        image.setImage(new Image(Main.stageController.readDatas(Main.stage1Name,0)));
    }

}
