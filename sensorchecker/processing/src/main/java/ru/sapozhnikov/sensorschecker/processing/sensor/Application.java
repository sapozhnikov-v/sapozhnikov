package ru.sapozhnikov.sensorschecker.processing.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.sapozhnikov.sensorschecker.processing.sensor.sensor.SensorValueListener;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

    }
    @Bean
    public SensorValueListener messageListener() {
        return new SensorValueListener();
    }
}
