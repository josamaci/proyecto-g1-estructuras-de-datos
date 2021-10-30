package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;

public class SettingsFXMLController {

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuFXML");
    }
}