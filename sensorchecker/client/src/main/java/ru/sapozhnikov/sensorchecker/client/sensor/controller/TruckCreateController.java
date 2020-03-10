package ru.sapozhnikov.sensorchecker.client.sensor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("truckCreator.fxml")

public class TruckCreateController {

    @Autowired
    MainWindowController mWC;
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Value(value = "${rest.url}/truckadd")
    private String url;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldTruckName;

    @FXML
    private TextField fieldTruckNumber;

    @FXML
    private Button buttonOk;

    @FXML
    private Button buttonCancel;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

    @FXML
    void initialize(ActionEvent event) {

        createTruck(new Truck(null, fieldTruckName.getText(), fieldTruckNumber.getText()));
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        mWC.initialize();

    }

    @FXML
    void initialize() {
        addTextLimiter(fieldTruckNumber, 9);

    }

    private void createTruck(Truck truck) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Truck> request = new HttpEntity<>(truck);
        Truck result = restTemplate.postForObject(url, request, Truck.class);
    }

    private void warningInputNumber() {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(WarningInputNumberController.class);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Ошибка ввода");
        stage.setScene(new Scene(root, 300, 100));
        stage.showAndWait();
    }

    private void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    warningInputNumber();
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

}

