module com.mycompany.jktseaworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens com.mycompany.jktseaworld to javafx.fxml;
    exports com.mycompany.jktseaworld;
}
