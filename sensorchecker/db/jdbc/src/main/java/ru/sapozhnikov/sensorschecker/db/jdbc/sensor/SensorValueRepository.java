package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.util.Date;


@Repository
public class SensorValueRepository {
    private static final String SQL_INSERT_SENSORS_VALUE = "insert into sensor_value (sensorvalue,id_sensor,action_date) values (?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSensorValue(SensorValue value) {

        jdbcTemplate.update(SQL_INSERT_SENSORS_VALUE, value.getValue(), value.getId(), new Date());

    }

}
