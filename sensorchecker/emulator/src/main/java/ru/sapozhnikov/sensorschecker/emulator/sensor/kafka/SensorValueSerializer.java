package ru.sapozhnikov.sensorschecker.emulator.sensor.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class SensorValueSerializer implements Serializer<SensorValue> {

    @Override
    public byte[] serialize(String s, SensorValue sensorValue) {

        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(sensorValue);
            objectOutputStream.flush();

            return outputStream.toByteArray();

        } catch (IOException e){
            throw new SerializationException("Error serializing", e);
        }
    }
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public void close() {

    }
}
