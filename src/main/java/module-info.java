module com.example.tiendacamaras {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tiendacamaras to javafx.fxml;
    exports com.example.tiendacamaras;
    exports com.example.tiendacamaras.controller;
    opens com.example.tiendacamaras.controller to javafx.fxml;
}