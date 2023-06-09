import java.io.*;
import java.net.*;
 

public class MultiThreadInit implements Runnable {
    private Socket socket;
 
    public MultiThreadInit(Socket socket) {
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
                MultiThread<Integer> thread = new MultiThread<>(new IntegerParser(), input, output);
                thread.start();
            }
            else if (type.equals("Double")) {
                MultiThread<Double> thread = new MultiThread<>(new DoubleParser(), input, output);
                thread.start();
            }
            else if (type.equals("String")) {
                MultiThread<String> thread = new MultiThread<>(new StringParser(), input, output);
                thread.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}