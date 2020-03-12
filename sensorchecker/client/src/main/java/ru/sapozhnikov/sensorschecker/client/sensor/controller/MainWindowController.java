package ru.sapozhnikov.sensorschecker.client.sensor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.client.sensor.component.SensorsListComponent;
import ru.sapozhnikov.sensorschecker.client.sensor.component.TruckListComponent;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

@Component
@FxmlView("mainWindow.fxml")
public class MainWindowController {

    private static final Logger logger = LogManager.getLogger(MainWindowController.class);

    private int truckIdFromTableTruck;

    @Autowired
    private ConfigurableApplicationContext applicationContext;
    private ObservableList<Sensor> sensorList = FXCollections.observableArrayList();
    private ObservableList<Truck> truckList = FXCollections.observableArrayList();
    @Autowired
    private TruckListComponent truckListComponent;

    @Autowired
    private SensorsListComponent sensorsListComponent;

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

    int getTruckIdFromTableTruck() {
        return truckIdFromTableTruck;
    }

    private void setTruckIdFromTableTruck(int truckIdFromTableTruck) {
        this.truckIdFromTableTruck = truckIdFromTableTruck;
    }

    @FXML
    void initialize() {
        logger.info("setItemsToTableSensor[]");
        setItemsToTableSensor();
        logger.info("setItemsToTableTruck[]");
        setItemsToTableTruck();
        buttonAddTruck.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                createNewWindow(TruckCreateController.class, "Добавление грузовика");
            }
        });

        buttonAddSensor.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                createNewWindow(SensorCreateController.class, "Добавление датчика");
            }
        });

        tableTruck.setRowFactory(tv -> {
            TableRow<Truck> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Truck rowData = row.getItem();
                    setTruckIdFromTableTruck(rowData.getId());
                    createNewWindow(SensorValueController.class, "Показания датчиков");
                }
            });
            return row;
        });
    }

    private void setItemsToTableSensor() {
        feelSensorList();
        columnSensorId.setCellValueFactory(new PropertyValueFactory<Sensor, Integer>("id"));
        columnSensorType.setCellValueFactory(new PropertyValueFactory<Sensor, SensorType>("type"));
        columnSensorName.setCellValueFactory(new PropertyValueFactory<Sensor, String>("name"));
        columnSensorTruckId.setCellValueFactory(new PropertyValueFactory<Sensor, Integer>("idTruck"));
        tableSensor.setItems(sensorList);
    }

    private void setItemsToTableTruck() {
        feelTruckList();
        columnTruckId.setCellValueFactory(new PropertyValueFactory<Truck, Integer>("id"));
        columnTruckName.setCellValueFactory(new PropertyValueFactory<Truck, String>("name"));
        columnTruckNumber.setCellValueFactory(new PropertyValueFactory<Truck, String>("number"));
        tableTruck.setItems(truckList);
    }

    private void feelSensorList() {
        sensorList.removeAll(sensorList);
        sensorList.addAll(sensorsListComponent.getSensors());
    }

    private void feelTruckList() {
        truckList.removeAll(truckList);
        truckList.addAll(truckListComponent.getTrucks());
    }

    private void createNewWindow(Class<?> controllerClass, String title) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(controllerClass);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}