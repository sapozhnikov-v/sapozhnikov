/*package chat;

import java.io.*;
import java.net.Socket;

public class ClientSomething {

    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader reader;
    private String addr;
    private int port;

    public ClientSomething(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.clientSocket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
        }
    }

    private class ReadMsg extends Thread {
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("exit")) {
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
            }
        }
    }

    private class WriteMsg extends Thread {
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = reader.readLine();
                    if (userWord.equals("exit")) {
                        out.write("exit" + "\n");
                        break;
                    } else {
                        out.write(userWord + "\n");
                        out.flush();
                    }

                } catch (IOException e) {
                }
            }

        }
    }
}
*/