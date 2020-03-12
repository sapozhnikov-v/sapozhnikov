package ru.sapozhnikov.sensorschecker.client.sensor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sapozhnikov.sensorschecker.client.sensor.controller.MainWindowController;

public class JavaFXApp extends Application {

    private static final Logger logger = LogManager.getLogger(JavaFXApp.class);

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpringBootApp.class)
                .run(args);
        logger.info("Application started");
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MainWindowController.class);
        stage.setTitle("Logistic God");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        logger.info("Application closed");
        this.applicationContext.close();
        Platform.exit();
    }

}
