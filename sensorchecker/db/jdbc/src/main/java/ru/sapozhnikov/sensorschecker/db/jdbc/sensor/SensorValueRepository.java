package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.util.Date;
import java.util.List;

@Repository
public class SensorValueRepository {

    private static final String SQL_INSERT_SENSORS_VALUE = "insert into sensor_value (sensor_value,sensor_id,action_date) " +
            "values (?,?,?)";
    private static final String SQL_GET_SENSORVALUE_BY_TRUCKID = "select sensor_value.id, sensor_id, sensor_value, action_date " +
            "from sensor_value join sensor on sensor_value.sensor_id=sensor.id " +
            "where truck_id=? order by action_date desc limit 3";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SensorValueMapper sensorValueMapper;

    public void addSensorValue(SensorValue value) {
        jdbcTemplate.update(SQL_INSERT_SENSORS_VALUE, value.getValue(), value.getSensorId(), new Date());
    }

    public List<SensorValue> getSensorValueByTruckid(int truckId) {
        return jdbcTemplate.query(SQL_GET_SENSORVALUE_BY_TRUCKID, sensorValueMapper, truckId);
    }

}
