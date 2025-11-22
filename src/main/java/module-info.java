module com.example.pokemoni {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.pokemoni to javafx.fxml;
    exports com.example.pokemoni;
}