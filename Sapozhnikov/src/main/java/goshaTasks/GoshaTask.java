package goshaTasks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Alina on 15.10.2019.
 */
/*
public class GoshaTask {
    public static void main(String[] args) throws IOException {


        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket s = serverSocket.accept();
                InputStream a = s.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(a));
                String line;
                line = reader.readLine();
                String[] parts = line.split(" ");

                System.out.println(parts[1]);
                File file = new File("c:/111" + parts[1]);
                System.out.println(file.exists());
                if (file.exists() == false) {
                    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
                        writer.write("HTTP/1.1 404 Not Found\n Not Found\n\n");
                    }
                } else {
                    try (BufferedReader reader1 = new BufferedReader(new FileReader("c:/111" + parts[1]))) {
                        String line1;
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        writer.write("HTTP/1.1 200 OK\n\n");
                        while ((line1 = reader1.readLine()) != null) {
                            writer.write(line1);
                            System.out.println(line1);
                        }
                        writer.write("\n\n");
                        writer.flush();
                    }
                }
            }
        }
    }
}
*/