package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ClientHandler client;

    public static void main(String[] args) {
        Thread readThread = new Thread(() ->{
            try {
                Scanner in = new Scanner(System.in);
                while (in.hasNext()) {
                    String message = in.nextLine();
                    if (client == null) {
                        System.out.println("No clients connected");
                        while (client == null) {

                            Thread.sleep(500);

                        }
                    }
                    if (client.isRunning()) {
                        client.sendMsg(message);
                        if (message.equals("/end")) {
                            client.setRunning(false);
                            break;
                        }
                    }
                }
            }catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });

        readThread.setDaemon(true);
        readThread.start();

       try(ServerSocket server = new ServerSocket(8089)){
           while (true){
               Socket socket = server.accept();
               client = new ClientHandler(socket);
               new Thread(client).start();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}

