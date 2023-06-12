import java.io.*;
import java.net.*;
 
//Thread for handling the client
public class ClientThread extends Thread {
    private Socket socket;
    private long id = getId();
 
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
 
    @Override
    public void run() {
        try {
             //For receiving data from the client
            InputStream inputStream = socket.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
    
            //For sending data to the client
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter output = new PrintWriter(outputStream, true);

            String type = input.readLine();
            
            if (type.equals("Integer")) {
                TreeOperations<Integer> treeRequests = new TreeOperations<>(new IntegerParser(), input, output);
                treeRequests.handleRequests();
            }
            else if (type.equals("Double")) {
                TreeOperations<Double> treeRequests = new TreeOperations<>(new DoubleParser(), input, output);
                treeRequests.handleRequests();
            }
            else if (type.equals("String")) {
                TreeOperations<String> treeRequests = new TreeOperations<>(new StringParser(), input, output);
                treeRequests.handleRequests();
            }
            
            System.out.println("Client " + id + " disconnected"); 

            //Close the socket
            try {
                socket.close();
            } catch (final IOException ex) {
                System.out.println("Error while closing socket: " + ex.getMessage());
                ex.printStackTrace();
            }
            
            //Stop the thread
            this.interrupt(); 
            
        } catch (final IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}