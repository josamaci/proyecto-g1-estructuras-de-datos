package espol.grupo_01;

import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController implements Initializable {

    @FXML
    private Button btPlay;
    @FXML
    private Button btOptions;
    @FXML
    private BorderPane bpMenu;
    @FXML
    private Label lbTitle;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!Reader.language){
            btPlay.setText("¡A jugar!");
            btOptions.setText("Idioma");
            lbTitle.setText("Caza Palabras");
        }else{
            btPlay.setText("Let's Play!");
            btOptions.setText("Language");
            lbTitle.setText("wordhunter");
        }
    } 
    
    @FXML
    private void switchToBoardSize(ActionEvent event) throws IOException {
        App.setRoot("SettingBoardSize");
    }
    
    @FXML
    private void switchToSettingsLanguage(ActionEvent event) throws IOException {
        App.setRoot("SettingsLanguage");
    }
}
