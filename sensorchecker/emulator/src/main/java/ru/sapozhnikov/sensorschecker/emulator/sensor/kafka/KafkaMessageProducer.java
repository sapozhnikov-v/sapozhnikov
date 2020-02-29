package ru.sapozhnikov.sensorschecker.emulator.sensor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

@Component
public class KafkaMessageProducer {

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, SensorValue> kafkaTemplate;


    public void sendMessage(SensorValue sensorValue) {

        ListenableFuture<SendResult<String, SensorValue>> future =
                kafkaTemplate.send(topicName, sensorValue);

        future.addCallback(new ListenableFutureCallback<SendResult<String, SensorValue>>() {

            @Override
            public void onSuccess(SendResult<String, SensorValue> result) {
                System.out.println("Sent message=[" + sensorValue +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + sensorValue + "] due to : " + ex.getMessage());
            }
        });
    }

}
