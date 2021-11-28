package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainMenuFXMLController {

    @FXML
    private Button btPlay;
    @FXML
    private BorderPane bpMenu;
    @FXML
    private Button btOptions;

    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("SettingBoardSize");
    }
}
