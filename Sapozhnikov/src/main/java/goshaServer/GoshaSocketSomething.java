package goshaServer;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class GoshaSocketSomething extends Thread {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private String lineInputHeader;

    GoshaSocketSomething(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
        this.out = socket.getOutputStream();
    }

    @Override
    public void run() {
        try {
            readInputHeaders();
            checkResponse();
        } catch (Throwable t) {
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
            }
        }
    }

    private void readInputHeaders() throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        lineInputHeader = reader.readLine();
    }

    private String readFileName() throws Throwable {
        String[] parts = lineInputHeader.split(" ");
        System.out.println(parts[1]);
        return parts[1];

    }

    private boolean checkFilePath() throws Throwable {
        File file = new File("c:/" + readFileName());
        return file.exists();

    }

    private void checkResponse() throws Throwable {
        if (checkFilePath()) writeResponseOK();
        else writeResponseErr();
    }

    private void writeResponseOK() throws Throwable {
        TimeUnit.SECONDS.sleep(5000);
        BufferedReader readerFile = new BufferedReader(new FileReader("c:/" + readFileName()));
        String lineFromFile;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("HTTP/1.1 200 OK\n\n");
        while ((lineFromFile = readerFile.readLine()) != null) {
            writer.write(lineFromFile);
            System.out.println(lineFromFile);
        }
        writer.write("\n\n");
        writer.flush();
    }

    private void writeResponseErr() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("HTTP/1.1 404 Not Found\n Not Found\n\n");
        writer.write("\n\n");
        writer.flush();

    }


}