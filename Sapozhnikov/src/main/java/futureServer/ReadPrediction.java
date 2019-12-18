package futureServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class ReadPrediction {

    private ArrayList<String> predictionsArray = new ArrayList<>();

    ReadPrediction() throws IOException {
        fillingArray();
    }

    private void fillingArray() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("c:/future.txt"));
        while (true) {
            String s = reader.readLine();
            if (s == null) break;
            predictionsArray.add(s);
        }
    }


    String getRandomPrediction() {
        int index = new Random().nextInt(predictionsArray.size());

        return predictionsArray.get(index);
    }
}



