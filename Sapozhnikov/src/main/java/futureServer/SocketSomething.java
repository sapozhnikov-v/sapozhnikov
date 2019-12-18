package futureServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketSomething extends Thread {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private ReadPrediction readPrediction = new ReadPrediction();

    SocketSomething(Socket socket) throws Throwable {
        this.socket = socket;
        this.in = socket.getInputStream();
        this.out = socket.getOutputStream();

    }

    @Override
    public void run() {
        try {
            readInputHeaders();
            writeResponse("<html><body><h1>" + readPrediction.getRandomPrediction() + "</h1></body></html>");
        } catch (Throwable t) {
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
            }
        }
        System.err.println("Client processing finished");
    }

    private void writeResponse(String s) throws Throwable {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: Sapozhnikov/2019-12-03\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + s.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        out.write(result.getBytes("cp1251"));
        out.flush();
    }

    private void readInputHeaders() throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null || line.trim().length() == 0) {
                break;
            }
        }
    }

}
