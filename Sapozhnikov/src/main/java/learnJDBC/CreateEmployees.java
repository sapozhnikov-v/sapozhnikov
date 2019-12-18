package learnJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CreateEmployees {
    public static void main(String[] args) throws IOException, SQLException {
        CreateArr createArr = new CreateArr();
        System.out.println(createArr.getArrEmp().toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Куда сохранить данные? FILE/LIST/DB");
        String storageType = reader.readLine();


        FactorySave factorySave = new FactorySave();
        Save save = factorySave.getSaveStorage(StorageTypes.valueOf(storageType));
        save.save(createArr.getArrEmp());

        System.out.println("Откуда прочитать данные? FILE/LIST/DB");
        String storageType1 = reader.readLine();

        FactoryRead factoryRead = new FactoryRead();
        Read read = factoryRead.readFromStorage(StorageTypes.valueOf(storageType1));
        read.read();


    }

}

