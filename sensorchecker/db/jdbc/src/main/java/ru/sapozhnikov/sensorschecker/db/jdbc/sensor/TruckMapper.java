package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TruckMapper implements RowMapper<Truck> {

    @Override
    public Truck mapRow(ResultSet resultSet, int i) throws SQLException {
        Truck truck = new Truck();
        truck.setId(resultSet.getInt("id"));
        truck.setName(resultSet.getString("name"));
        truck.setNumber(resultSet.getString("number"));
        return truck;
    }

}
