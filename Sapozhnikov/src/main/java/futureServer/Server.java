package futureServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) throws Throwable {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket s = server.accept();
            new Thread(new SocketSomething(s)).start();
            log.info("new thread");
        }
    }
}
