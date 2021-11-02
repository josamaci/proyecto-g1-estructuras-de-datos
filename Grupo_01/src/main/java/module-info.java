module espol.grupo_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens espol.grupo_01 to javafx.fxml;
    exports espol.grupo_01;
}
