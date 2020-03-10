package ru.sapozhnikov.sensorchecker.client.sensor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("warningInputNumber.fxml")
public class WarningInputNumberController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonOk;

    @FXML
    void initialize(ActionEvent event) {

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

    @FXML
    void initialize() {

    }
}


