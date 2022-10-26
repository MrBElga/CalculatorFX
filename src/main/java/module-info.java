module com.example.fxcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxcalculator to javafx.fxml;
    exports com.example.fxcalculator;
}