package espol.grupo_01;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

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
    
    private boolean b7;
    private boolean b9;
    private boolean b11;
    private boolean b13;
    private boolean bR;
    @FXML
    private ToggleButton tbtWAnimals;
    @FXML
    private ToggleButton tbtWSports;
    @FXML
    private ToggleButton tbtWColors;
    @FXML
    private ToggleButton tbtWBrands;
    @FXML
    private ToggleButton tbtWColors1;
    @FXML
    private ToggleButton tbtWBrands1;
    
    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuFXML");
    }
    @FXML
    private void switchToGame() throws IOException {
        App.setRoot("PlayboardFXML");
    }

    @FXML
    private void boardSize7(MouseEvent event) {
        b7 = true;
        b9 = false;
        b11 = false;
        b13 = false;
        bR = false;
        btBoard9.setSelected(b9);
        btBoard11.setSelected(b11);
        btBoard13.setSelected(b13);
        btBoardRd.setSelected(bR);
    }

    @FXML
    private void boardSize9(MouseEvent event) {
        b7 = false;
        b9 = true;
        b11 = false;
        b13 = false;
        bR = false;
        btBoard7.setSelected(b7);
        btBoard11.setSelected(b11);
        btBoard13.setSelected(b13);
        btBoardRd.setSelected(bR);
    }

    @FXML
    private void boardSize11(MouseEvent event) {
        b7 = false;
        b9 = false;
        b11 = true;
        b13 = false;
        bR = false;
        btBoard7.setSelected(b7);
        btBoard9.setSelected(b9);
        btBoard13.setSelected(b13);
        btBoardRd.setSelected(bR);
    }

    @FXML
    private void boardSize13(MouseEvent event) {
        b7 = false;
        b9 = false;
        b11 = false;
        b13 = true;
        bR = false;
        btBoard7.setSelected(b7);
        btBoard9.setSelected(b9);
        btBoard11.setSelected(b11);
        btBoardRd.setSelected(bR);
    }

    @FXML
    private void boardSizeRandom(MouseEvent event) {
        b7 = false;
        b9 = false;
        b11 = false;
        b13 = false;
        bR = true;
        btBoard7.setSelected(b7);
        btBoard9.setSelected(b9);
        btBoard11.setSelected(b11);
        btBoard13.setSelected(b13);
    }

}