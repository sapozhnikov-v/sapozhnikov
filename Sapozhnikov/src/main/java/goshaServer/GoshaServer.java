package goshaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GoshaServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket s = server.accept();
            new Thread(new GoshaSocketSomething(s)).start();
        }
    }

}
