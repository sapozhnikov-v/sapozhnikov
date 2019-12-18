package learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbSingleton {
    private static ConnectionDbSingleton instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "vet";
    private String password = "vet";

    private ConnectionDbSingleton() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection failed" + ex.getMessage());
        }
    }

    public static ConnectionDbSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionDbSingleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectionDbSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
    }
}