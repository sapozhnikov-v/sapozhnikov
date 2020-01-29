package learnJDBC;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionDbSingleton {

    private static Logger logger = LogManager.getLogger();

    private static ConnectionDbSingleton instance;
    private ConfigLoad cL = ConfigLoad.getInstance();


    private ConnectionDbSingleton() throws IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection failed" + ex.getMessage());
        }
    }

    static ConnectionDbSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new ConnectionDbSingleton();
            logger.info("Connect OK");
        }
        return instance;
    }

    Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(cL.getUrl(), cL.getUsername(), cL.getPassword());
        return connection;
    }

}