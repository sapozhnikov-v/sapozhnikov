package learnJDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile implements Read {

    @Override
    public void read() throws IOException {
        ArrayList<Employees> listFromFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("c:/employees.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            Employees employeesFromFile = new EmployeesBuilder()
                    .userId(Integer.parseInt(parts[0]))
                    .name(parts[1])
                    .age(Integer.parseInt(parts[2]))
                    .roomId(Integer.parseInt(parts[3]))
                    .bulid();
            listFromFile.add(employeesFromFile);

        }
        System.out.println(listFromFile.toString());


    }
}
