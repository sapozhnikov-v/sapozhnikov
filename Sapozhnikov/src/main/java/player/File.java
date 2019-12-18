package player;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class File {

    public static void main(String[] args) {

        ArrayList<Player> list = new ArrayList<Player>();

        try (BufferedReader reader = new BufferedReader(new FileReader("c:/players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                list.add(new Player(Integer.parseInt(parts[0]), parts[1], parts[2]));
            }
        }
        catch (IOException e) {
            System.err.println("Error reading file");
        }

        Collections.sort(list);

        System.out.println(list.toString());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("c:/playersSorted.txt"))){
            for (int i=0;i<list.size();i++){
                if (i>0){
                    writer.write(System.lineSeparator());
                }
                writer.write(list.get(i).toString());
            }


        }
        catch (IOException e){
            System.err.println("Error writing file");
        }
    }
}
