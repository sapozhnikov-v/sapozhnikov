package learnJDBC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToFile implements Save {


    @Override
    public void save(List<Employees> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:/employees.txt", true));
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i).toString() + "\r\n");
            writer.close();
        }


    }
}
