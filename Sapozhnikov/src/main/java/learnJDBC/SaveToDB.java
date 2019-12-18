package learnJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveToDB implements Save {


    @Override
    public void save(List<Employees> list) throws SQLException {
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
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}