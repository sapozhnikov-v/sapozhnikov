package ru.sapozhnikov.sensorschecker.db.rest.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "ru.sapozhnikov.sensorschecker.db")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
