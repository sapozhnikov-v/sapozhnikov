package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class SensorValueMapper implements RowMapper<SensorValue> {

    @Override
    public SensorValue mapRow(ResultSet resultSet, int i) throws SQLException {
        SensorValue sensorValue = new SensorValue();
        sensorValue.setId(resultSet.getInt("id"));
        sensorValue.setSensorId(resultSet.getInt("sensor_id"));
        sensorValue.setValue(resultSet.getInt("sensor_value"));
        sensorValue.setDate(resultSet.getTimestamp("action_date"));
        return sensorValue;
    }
}
