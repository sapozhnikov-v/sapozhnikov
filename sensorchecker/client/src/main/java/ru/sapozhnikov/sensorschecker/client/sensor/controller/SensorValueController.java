package ru.sapozhnikov.sensorschecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.client.sensor.component.SensorValueListComponent;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.util.Date;

@Component
@FxmlView("sensorValue.fxml")
public class SensorValueController {

    @Autowired
    private SensorValueListComponent sensorValueListComponent;

    @Autowired
    private MainWindowController mainWindowController;

    private ObservableList<SensorValue> sensorValueList = FXCollections.observableArrayList();

    @FXML
    private TableView<SensorValue> tableSensorValue;

    @FXML
    private TableColumn<SensorValue, Integer> columnSensorValueId;

    @FXML
    private TableColumn<SensorValue, Integer> columnSensorId;

    @FXML
    private TableColumn<SensorValue, Integer> columnSensorValue;

    @FXML
    private TableColumn<SensorValue, Date> columnActionDate;

    @FXML
    void initialize() {
        setItemsToTableSensorValue(mainWindowController.getTruckIdFromTableTruck());
    }

    private void setItemsToTableSensorValue(int truckId) {
        feelSensorValueList(truckId);
        columnSensorValueId.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("id"));
        columnSensorId.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("sensorId"));
        columnSensorValue.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("value"));
        columnActionDate.setCellValueFactory(new PropertyValueFactory<SensorValue, Date>("date"));
        tableSensorValue.setItems(sensorValueList);
    }

    private void feelSensorValueList(int truckId) {
        sensorValueList.removeAll(sensorValueList);
        sensorValueList.addAll(sensorValueListComponent.getSensorValueByTruckId(truckId));
    }

}