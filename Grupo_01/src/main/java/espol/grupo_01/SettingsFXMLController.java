package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class SettingsFXMLController {

    @FXML
    private Tab boardTab;
    @FXML
    private Button toMainMenuBtn;

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuFXML");
    }
}