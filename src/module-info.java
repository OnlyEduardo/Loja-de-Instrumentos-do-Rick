module InstrumentsStore {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;

    exports com.swellshinider.main;
    exports com.swellshinider.view;
    exports com.swellshinider.util;
    exports com.swellshinider.specs;
    exports com.swellshinider.enumerators;

    opens com.swellshinider.controller to javafx.fxml;
}