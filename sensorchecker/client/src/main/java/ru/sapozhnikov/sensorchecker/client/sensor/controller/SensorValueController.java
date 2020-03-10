package ru.sapozhnikov.sensorchecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorchecker.client.sensor.importer.SensorValueListImporter;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Component
@FxmlView("sensorValue.fxml")
public class SensorValueController {

    @Autowired
    SensorValueListImporter sVLI;
    @Autowired
    MainWindowController mVC;
    private ObservableList<SensorValue> sensorValueList = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

        setItemsToTableSensorValue(MainWindowController.truckIdFromTableTruck);

    }

    private void setItemsToTableSensorValue(int truckId) {
        initSensorValueData(truckId);

        columnSensorValueId.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("id"));
        columnSensorId.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("sensorId"));
        columnSensorValue.setCellValueFactory(new PropertyValueFactory<SensorValue, Integer>("value"));
        columnActionDate.setCellValueFactory(new PropertyValueFactory<SensorValue, Date>("date"));

        tableSensorValue.setItems(sensorValueList);

    }

    private void initSensorValueData(int truckId) {

        sensorValueList.removeAll(sensorValueList);
        sensorValueList.addAll(sVLI.getSensorValueByTruckId(truckId));
    }

}