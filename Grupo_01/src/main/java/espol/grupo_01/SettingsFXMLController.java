package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;

public class SettingsFXMLController {

    @FXML
    private Tab boardTab;
    @FXML
    private Button btBackToTitle;
    @FXML
    private ToggleButton btBoard7;
    @FXML
    private ToggleButton btBoard9;
    @FXML
    private ToggleButton btBoard11;
    @FXML
    private ToggleButton btBoard13;
    @FXML
    private ToggleButton btBoardRd;
    @FXML
    private Button btStartGame;

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuFXML");
    }
    @FXML
    private void switchToGame() throws IOException {
        App.setRoot("PlayboardFXML");
    }

}