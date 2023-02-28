module fr.miniprojet3.miniprojet3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens fr.miniprojet3.miniprojet3 to javafx.fxml;
    exports fr.miniprojet3.miniprojet3;

}