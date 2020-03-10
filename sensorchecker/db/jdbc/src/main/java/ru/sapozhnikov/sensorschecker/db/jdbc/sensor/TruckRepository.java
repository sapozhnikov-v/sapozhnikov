package ru.sapozhnikov.sensorschecker.db.jdbc.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.util.List;

@Repository
public class TruckRepository {
    private static final String SQL_GET_TRUCKS = "select * from truck order by id";
    private static final String SQL_ADD_TRUCK = "insert into truck (name,number) values (?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TruckMapper tM;

    public List<Truck> getAllTrucks() {
        return jdbcTemplate.query(SQL_GET_TRUCKS, tM);
    }

    public void addTruck(Truck truck) {

        jdbcTemplate.update(SQL_ADD_TRUCK, truck.getName(),truck.getNumber());

    }

}
