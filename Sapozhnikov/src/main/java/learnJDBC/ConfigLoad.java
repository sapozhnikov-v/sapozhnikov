package learnJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class ConfigLoad {

    private static ConfigLoad instance;
    private String url;
    private String username;
    private  String password;
    private String filepath;
    private String datasource;




    private ConfigLoad() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("config"));
        Properties properties = new Properties();
        properties.load(fileInputStream);
        url = properties.getProperty("db.url");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
        filepath = properties.getProperty("filepath");
        datasource = properties.getProperty("datasource");

    }


    static ConfigLoad getInstance() throws IOException {
        if (instance == null) {
            instance = new ConfigLoad();
        }
        return instance;
    }

    String getUrl(){
        return url;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getFilepath() {
        return filepath;
    }

    String getDatasource() {
        return datasource;
    }

}
