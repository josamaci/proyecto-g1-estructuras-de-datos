package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuFXMLController {

    @FXML
    private Button playBtn;

    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("SettingBoardSize");
    }
}
