package goshaTasks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Alina on 15.10.2019.
 */
public class GoshaTask {
    public static void main(String[] args) throws IOException {


        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket s = server.accept();
                InputStream a = s.getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(a))) {
                    String line;
                    line = reader.readLine();
                    String[] parts = line.split(" ");

                    System.out.println(parts[1]);
                    File file = new File("c:/" + parts[1]);
                    System.out.println(file.exists());
                    if (file.exists() == false) {
                        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
                            writer.write("HTTP/1.1 404 Not Found\n Not Found\n\n");
                            writer.write("\n\n");
                            writer.flush();
                        }
                    } else {
                        try (BufferedReader reader1 = new BufferedReader(new FileReader("c:/" + parts[1]))) {
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
}
