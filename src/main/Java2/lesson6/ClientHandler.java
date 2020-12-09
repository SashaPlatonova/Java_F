package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private DataInputStream is;
    private DataOutputStream os;
    private boolean running;

    public ClientHandler(Socket socket) throws IOException {
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void sendMsg(String message) throws IOException {
        os.writeUTF(message);
        os.flush();
    }

    @Override
    public void run() {
        while (running) {
            String messageFromClient = null;
            try {
                messageFromClient = is.readUTF();
                System.out.println("Message from Client: " + messageFromClient);
                if (messageFromClient.equals("/end")) {
                    os.writeUTF(messageFromClient);
                    os.flush();
                    running = false;
                    break;
                }
            } catch (IOException e) {
                System.out.println("Connection was broken");
            }
        }
    }
}
