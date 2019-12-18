package futureServer;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Throwable {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket s = server.accept();
            new Thread(new SocketSomething(s)).start();
        }
    }
}
