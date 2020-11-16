package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 1080;

    public static void main(String[] args) {
//        new DataBase().start();

        System.out.println("Server started!");

        try (
                ServerSocket server = new ServerSocket(PORT, 50, InetAddress.getByName(ADDRESS))) {

            Session session = new Session(server.accept());
            session.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Session extends Thread {
    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    public void run() {

        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            System.out.println("Received: " + input.readUTF());

            String message = "A record # 12 was sent!";
            System.out.println("Sent: " + message);
            output.writeUTF(message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}