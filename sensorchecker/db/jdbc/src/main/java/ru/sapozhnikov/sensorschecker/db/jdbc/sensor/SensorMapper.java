package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SensorMapper implements RowMapper<Sensor> {

    @Override
    public Sensor mapRow(ResultSet resultSet, int i) throws SQLException {
        Sensor sensor = new Sensor();
        sensor.setId(resultSet.getInt("id"));
        sensor.setType(SensorType.valueOf(resultSet.getString("type").toUpperCase()));
        sensor.setName(resultSet.getString("name"));
        sensor.setIdTruck(resultSet.getInt("truck_id"));
        return sensor;
    }

}
