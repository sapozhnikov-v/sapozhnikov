package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;

import java.util.List;

@Repository
public class SensorRepository {
    private static final String SQL_GET_SENSORS = "select * from sensor order by id";
    private static final String SQL_ADD_SENSOR = "insert into sensor (type,name,truck_id) values (?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SensorMapper sM;

    public List<Sensor> getAllSensors() {
        return jdbcTemplate.query(SQL_GET_SENSORS, sM);
    }

    public void addSensor(Sensor sensor) {

        jdbcTemplate.update(SQL_ADD_SENSOR, sensor.getType().toString(),sensor.getName(),sensor.getIdTruck());

    }

}
