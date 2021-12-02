
import javafx.collections.ObservableList;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Another {
    
    static GridPane gridPane;
    int size;

    public Another(int size) {
        this.size = size;
        gridPane = new GridPane();
    }
    
    private void fillGrid() {
        
        ObservableList<RowConstraints> rowConstraints = gridPane.getRowConstraints();
        ObservableList<ColumnConstraints> columnConstraints = gridPane.getColumnConstraints();
        
    }
    
}
