import java.io.*;
import java.net.*;
 

public class MultiThreadInit {
    private Socket socket;
 
    public MultiThreadInit(Socket socket) {
        this.socket = socket;
    }
 
    public void startInit() {

        try {
             //Odbieranie od klienta
            InputStream inputStream = socket.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
    
            //Wysylanie do klienta
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter output = new PrintWriter(outputStream, true);

            String type = input.readLine();
            
            if (type.equals("Integer")) {
                MultiThread<Integer> thread = new MultiThread<>(new IntegerParser(), input, output);
                thread.start();
            }
            else if (type.equals("Double")) {
                MultiThread<Integer> thread = new MultiThread<>(new DoubleParser(), input, output);
                thread.start();
            }
            else if (type.equals("String")) {
                MultiThread<Integer> thread = new MultiThread<>(new StringParser(), input, output);
                thread.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}