package ru.sapozhnikov.sensorchecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorchecker.client.sensor.importer.SensorsListImporter;
import ru.sapozhnikov.sensorchecker.client.sensor.importer.TruckListImporter;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("mainWindow.fxml")
public class MainWindowController {

    static int truckIdFromTableTruck;
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    private ObservableList<Sensor> sensorList = FXCollections.observableArrayList();
    private ObservableList<Truck> truckList = FXCollections.observableArrayList();
    @Autowired
    private TruckListImporter tLI;

    @Autowired
    private SensorsListImporter sLI;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tabTruck;

    @FXML
    private TableView<Truck> tableTruck;

    @FXML
    private TableColumn<Truck, Integer> columnTruckId;

    @FXML
    private TableColumn<Truck, String> columnTruckName;

    @FXML
    private TableColumn<Truck, String> columnTruckNumber;

    @FXML
    private Button buttonAddTruck;

    @FXML
    private Tab tabSensor;

    @FXML
    private TableView<Sensor> tableSensor;

    @FXML
    private TableColumn<Sensor, Integer> columnSensorId;

    @FXML
    private TableColumn<Sensor, SensorType> columnSensorType;

    @FXML
    private TableColumn<Sensor, String> columnSensorName;

    @FXML
    private TableColumn<Sensor, Integer> columnSensorTruckId;

    @FXML
    private Button buttonAddSensor;

    @FXML
    void initialize() {

        setItemsToTableSensor();
        setItemsToTableTruck();

        buttonAddTruck.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                createNewWindow(TruckCreateController.class, "Добавление грузовика", 300, 200);

            }
        });

        buttonAddSensor.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                createNewWindow(SensorCreateController.class, "Добавление датчика", 300, 185);
            }
        });

        tableTruck.setRowFactory(tv -> {
            TableRow<Truck> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Truck rowData = row.getItem();
                    System.out.println("Double click on: " + rowData.getId());

                    truckIdFromTableTruck = rowData.getId();

                    createNewWindow(SensorValueController.class, "Показания датчиков", 500, 200);

                }
            });
            return row;
        });
    }


    private void setItemsToTableSensor() {
        initSensorData();

        columnSensorId.setCellValueFactory(new PropertyValueFactory<Sensor, Integer>("id"));
        columnSensorType.setCellValueFactory(new PropertyValueFactory<Sensor, SensorType>("type"));
        columnSensorName.setCellValueFactory(new PropertyValueFactory<Sensor, String>("name"));
        columnSensorTruckId.setCellValueFactory(new PropertyValueFactory<Sensor, Integer>("idTruck"));

        tableSensor.setItems(sensorList);

    }

    private void setItemsToTableTruck() {
        initTruckData();

        columnTruckId.setCellValueFactory(new PropertyValueFactory<Truck, Integer>("id"));
        columnTruckName.setCellValueFactory(new PropertyValueFactory<Truck, String>("name"));
        columnTruckNumber.setCellValueFactory(new PropertyValueFactory<Truck, String>("number"));

        tableTruck.setItems(truckList);

    }


    private void initSensorData() {

        sensorList.removeAll(sensorList);
        sensorList.addAll(sLI.getSensors());
    }

    private void initTruckData() {

        truckList.removeAll(truckList);
        truckList.addAll(tLI.getTrucks());
    }

    private void createNewWindow(Class<?> controllerClass, String title, int width, int height) {

        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(controllerClass);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.showAndWait();

    }


}