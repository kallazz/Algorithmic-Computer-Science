import java.io.*;
import java.net.*;
 

public class Server {
 
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(4444)) {
 
            System.out.println("Server is listening on port 4444");
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
 
                new ClientThread(socket).start();
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}