package ru.sapozhnikov.sensorschecker.emulator.sensor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.emulator.sensor.emulator.SensorEmulator;

@EnableScheduling
@Component
public class SheduledProducer {

    @Autowired
    private SensorEmulator emulator;
    @Autowired
    private KafkaMessageProducer producer;

    @Scheduled(fixedRateString = "${rate.value.generate}")
    public void sendMessagetoKafka() {
        emulator.sensorEmulate().forEach(producer::sendMessage);
    }

}
