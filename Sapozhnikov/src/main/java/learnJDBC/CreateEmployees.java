package learnJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CreateEmployees {
    public static void main(String[] args) throws IOException, SQLException {
        ConfigLoad cL = ConfigLoad.getInstance();
        CreateArr createArr = new CreateArr();

        System.out.println(createArr.employeesArrayList);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(cL.getDatasource());
        String storageType = reader.readLine();


        FactoryStorage factoryStorage = new FactoryStorage();
        SaveRead save = factoryStorage.saveReadStorage(StorageTypes.valueOf(storageType));
        save.save(createArr.employeesArrayList);

        SaveRead read = save;
        System.out.println(read.read().toString());


    }

}

