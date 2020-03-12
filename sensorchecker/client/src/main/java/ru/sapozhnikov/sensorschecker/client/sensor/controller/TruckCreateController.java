package ru.sapozhnikov.sensorschecker.client.sensor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.client.sensor.component.TruckListComponent;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;
import ru.sapozhnikov.sensorschecker.core.sensor.util.StringUtils;

@Component
@FxmlView("truckCreator.fxml")
public class TruckCreateController {

    @Autowired
    private MainWindowController mWC;

    @Autowired
    private TruckListComponent tLI;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @FXML
    private TextField fieldTruckName;

    @FXML
    private TextField fieldTruckNumber;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void initialize(ActionEvent event) {
        if ((StringUtils.fieldIsEmpty(fieldTruckName.getText()))
                || (StringUtils.fieldIsEmpty(fieldTruckNumber.getText()))) {
            showWarningEmptyField();
            return;
        }
        tLI.createTruck(new Truck(null, fieldTruckName.getText(), fieldTruckNumber.getText()));
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        mWC.initialize();
    }

    @FXML
    void initialize() {
        addTextLimiter(fieldTruckNumber, 9);
    }

    private void showWarningInputNumber() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText(null);
        alert.setContentText("Номер не должен содержать более 9 символов");
        alert.showAndWait();
    }

    private void showWarningEmptyField() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText(null);
        alert.setContentText("Поля не должны быть пустыми");
        alert.showAndWait();
    }

    private void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    showWarningInputNumber();
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

}

