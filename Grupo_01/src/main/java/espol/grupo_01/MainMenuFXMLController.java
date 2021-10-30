package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainMenuFXMLController {

    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("SettingsFXML");
    }
}
