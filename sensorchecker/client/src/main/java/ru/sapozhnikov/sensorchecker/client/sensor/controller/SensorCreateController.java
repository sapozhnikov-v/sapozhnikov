package ru.sapozhnikov.sensorchecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorchecker.client.sensor.importer.TruckListImporter;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("sensorCreator.fxml")
public class SensorCreateController {

    @Autowired
    private MainWindowController mWC;

    @Autowired
    private TruckListImporter tLI;

    private ObservableList<Integer> truckIdList = FXCollections.observableArrayList();
    private ObservableList<SensorType> sensorTypesList = FXCollections.observableArrayList();

    @Value(value = "${rest.url}/sensoradd")
    private String url;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldSensorName;

    @FXML
    private Button buttonOk;

    @FXML
    private Button buttonCancel;

    @FXML
    private ChoiceBox<SensorType> choiceBoxSensorType;

    @FXML
    private ChoiceBox<Integer> choiceBoxTruckId;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

    @FXML
    void initialize(ActionEvent event) {

        createSensor(new Sensor(null, choiceBoxSensorType.getValue(), fieldSensorName.getText(), choiceBoxTruckId.getValue()));
        System.out.println(choiceBoxSensorType.getValue() + " " + fieldSensorName.getText() + " " + choiceBoxTruckId.getValue());
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        mWC.initialize();

    }

    @FXML
    void initialize() {

        setItemToChoiceBoxSensorType();
        setItemToChoiceBoxTruckIdList(tLI.getTrucks());


    }

    private void createSensor(Sensor sensor) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Sensor> request = new HttpEntity<>(sensor);
        Sensor result = restTemplate.postForObject(url, request, Sensor.class);
    }

    private void setItemToChoiceBoxSensorType() {
        feelingSensorTypeList();
        choiceBoxSensorType.setItems(sensorTypesList);
    }

    private void setItemToChoiceBoxTruckIdList(List<Truck> list) {
        feelingTruckIdList(list);
        choiceBoxTruckId.setItems(truckIdList);
    }

    private void feelingTruckIdList(List<Truck> list) {
        truckIdList.removeAll(truckIdList);
        for (Truck truck : list) {
            truckIdList.add(truck.getId());
        }
    }

    private void feelingSensorTypeList() {
        sensorTypesList.removeAll(sensorTypesList);
        sensorTypesList.addAll(SensorType.values());
    }


}
