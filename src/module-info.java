module InstrumentsStore {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;

    exports com.swellshinider.main;
    exports com.swellshinider.view;
    exports com.swellshinider.instruments.specs;
    exports com.swellshinider.instruments.enumerators;

    opens com.swellshinider.controller to javafx.fxml;
}