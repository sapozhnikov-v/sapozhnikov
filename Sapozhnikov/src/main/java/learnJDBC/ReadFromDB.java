package learnJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFromDB implements Read {
    @Override
    public void read() throws SQLException {
        try(

        Connection connection = ConnectionDbSingleton.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEES");
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("USER_ID");
                String username = resultSet.getString("USERNAME");
                int userage = resultSet.getInt("USERAGE");
                int roomId = resultSet.getInt("ROOMID");
                System.out.println(userId + " | " + username + " | " + userage + " | " + roomId);
            }
        }



    }
}
