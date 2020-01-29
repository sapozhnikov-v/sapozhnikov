package learnJDBC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File implements SaveRead {
    private ConfigLoad cL;

    {
        try {
            cL = ConfigLoad.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void save(List<Employees> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(cL.getFilepath(), true));
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i).toString() + "\r\n");
        }
        writer.close();


    }

    @Override
    public List<Employees> read() throws IOException {
        ArrayList<Employees> listFromFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(cL.getFilepath()));
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
        return listFromFile;

    }
}
