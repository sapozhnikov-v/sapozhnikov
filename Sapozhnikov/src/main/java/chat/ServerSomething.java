/*package chat;

import java.io.*;
import java.net.Socket;

public class ServerSomething extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerSomething (Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                if (word.equals("exit")) {
                    break;}
                    for (ServerSomething vr : Server.serverList) {
                        if (this.socket.equals(vr.socket)) continue;
                        vr.send(word);
                    }
                }
            } catch(IOException e){
            }
        }

        private void send (String msg){
            try{
                out.write(msg + "\n");
                out.flush();
            } catch (IOException ignored){}
        }
}
*/