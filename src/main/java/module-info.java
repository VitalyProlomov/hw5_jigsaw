module com.example.hw5_jigsaw {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hw5_jigsaw to javafx.fxml;
    exports com.example.hw5_jigsaw;
}