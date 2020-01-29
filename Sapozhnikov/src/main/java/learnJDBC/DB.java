package learnJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB implements SaveRead {


    @Override
    public void save(List<Employees> list) throws SQLException, IOException {
        try (
                Connection connection = ConnectionDbSingleton.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO EMPLOYEES (USER_ID, USERNAME, USERAGE,ROOMID) " +
                        "VALUES (?,?,?,?)");

        ) {

            for (Employees obj : list) {

                statement.setInt(1, obj.getUserId());
                statement.setString(2, obj.getName());
                statement.setInt(3, obj.getAge());
                statement.setInt(4, obj.getRoomId());
                statement.executeUpdate();


            }
        }
    }

    @Override
    public List<Employees> read() throws SQLException, IOException {
        ArrayList<Employees> listDb = new ArrayList<>();
        try (

                Connection connection = ConnectionDbSingleton.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEES");
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("USER_ID");
                String username = resultSet.getString("USERNAME");
                int userage = resultSet.getInt("USERAGE");
                int roomId = resultSet.getInt("ROOMID");
                Employees employeesFromFile = new EmployeesBuilder()
                        .userId(userId)
                        .name(username)
                        .age(userage)
                        .roomId(roomId)
                        .bulid();
                listDb.add(employeesFromFile);
            }
        }
        return listDb;
    }
}