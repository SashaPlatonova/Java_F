package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class StartClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8089);
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        Thread writeThread = new Thread(() -> {
            try {
                Scanner in = new Scanner(System.in);
                while (in.hasNext()){
                    String message = in.nextLine();

                        os.writeUTF(message);

                    os.flush();
                    if (message.equals("/end")){
                        break;
                    }
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
        });
        Thread readThread = new Thread(() ->{
            try {
                while (true){
                    String messageFromServer = null;
                    messageFromServer = is.readUTF();
                    System.out.println("Message from Server:" + messageFromServer);
                    if (messageFromServer.equals("/end")){
                        System.out.println("Program is finished");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection interrupted");
            }
        });
        writeThread.setDaemon(true);
        writeThread.start();
        readThread.start();

    }
}
