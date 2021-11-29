package espol.grupo_01;

import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainMenuFXMLController implements Initializable {

    @FXML
    private Button btPlay;
    @FXML
    private BorderPane bpMenu;
    @FXML
    private Button btOptions;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void switchToSettings(ActionEvent event) throws IOException {
        App.setRoot("SettingBoardSize");
    }
}
