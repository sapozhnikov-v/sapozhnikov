package ru.sapozhnikov.sensorschecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.client.sensor.component.SensorsListComponent;
import ru.sapozhnikov.sensorschecker.client.sensor.component.TruckListComponent;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;
import ru.sapozhnikov.sensorschecker.core.sensor.util.StringUtils;

import java.util.List;

@Component
@FxmlView("sensorCreator.fxml")
public class SensorCreateController {

    @Autowired
    private MainWindowController mainWindowController;

    @Autowired
    private TruckListComponent truckListComponent;

    @Autowired
    private SensorsListComponent sensorsListComponent;

    private ObservableList<Truck> truckIdList = FXCollections.observableArrayList();
    private ObservableList<SensorType> sensorTypesList = FXCollections.observableArrayList();

    @FXML
    private TextField fieldSensorName;

    @FXML
    private ChoiceBox<SensorType> choiceBoxSensorType;

    @FXML
    private ChoiceBox<Truck> choiceBoxTruckId;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void initialize(ActionEvent event) {
        if (StringUtils.fieldIsEmpty(fieldSensorName.getText())
                || choiceBoxSensorType.getValue() == null || choiceBoxTruckId.getValue() == null) {
            showWarningEmptyField();
            return;
        }
        sensorsListComponent.createSensor(new Sensor(null, choiceBoxSensorType.getValue(), fieldSensorName.getText(),
                choiceBoxTruckId.getValue().getId()));
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        mainWindowController.initialize();
    }

    @FXML
    void initialize() {
        setItemToChoiceBoxSensorType();
        setItemToChoiceBoxTruckIdList(truckListComponent.getTrucks());
    }

    private void setItemToChoiceBoxSensorType() {
        feelSensorTypeList();
        choiceBoxSensorType.setItems(sensorTypesList);
    }

    private void setItemToChoiceBoxTruckIdList(List<Truck> list) {
        feelTruckIdList(list);
        choiceBoxTruckId.setItems(truckIdList);
        choiceBoxTruckId.setConverter(new StringConverter<Truck>() {
            @Override
            public String toString(Truck object) {
                return object.getNumber();
            }

            @Override
            public Truck fromString(String string) {
                return null;
            }
        });
    }

    private void feelTruckIdList(List<Truck> list) {
        truckIdList.removeAll(truckIdList);
        truckIdList.addAll(list);
    }

    private void feelSensorTypeList() {
        sensorTypesList.removeAll(sensorTypesList);
        sensorTypesList.addAll(SensorType.values());
    }

    private void showWarningEmptyField() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText(null);
        alert.setContentText("Поля не должны быть пустыми");
        alert.showAndWait();
    }

}
