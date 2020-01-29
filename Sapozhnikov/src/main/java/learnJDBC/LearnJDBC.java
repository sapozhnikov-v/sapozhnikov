/*package learnJDBC;

import java.sql.SQLException;
import java.sql.Statement;

import static learnJDBC.ConnectionDbSingleton.getInstance;

public class LearnJDBC {
    public static void main(String[] args) throws SQLException {

        try {
            createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createDbUserTable() throws SQLException {
        ConnectionDbSingleton dbConnection = null;
        Statement statement = null;

        String createTableSQL = "create table EMPLOYEES("
                + "USER_ID numeric (5) primary key , "
                + "USERNAME varchar(20) not null , "
                + "USERAGE numeric(3) not null , "
                + "ROOMID numeric(4) not null"
                + ")";
        try {
            dbConnection = getInstance();
            statement = dbConnection.getConnection().createStatement();

            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser5\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
*/