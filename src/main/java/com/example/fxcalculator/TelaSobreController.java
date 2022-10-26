package com.example.fxcalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TelaSobreController {

    public void onCloseAbout(ActionEvent actionEvent) {
        ((Button)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
