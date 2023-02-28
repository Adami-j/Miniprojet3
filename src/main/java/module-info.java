module fr.miniprojet3.miniprojet3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.miniprojet3.miniprojet3 to javafx.fxml;
    exports fr.miniprojet3.miniprojet3;
}