import java.io.*;
import java.net.*;
import java.util.Scanner;


public class simpleClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        
        // Create socket to connect to server.
        Socket socket = new Socket("localhost", 4242);
      
        // Scanner to read user message to the server.
        Scanner scan = new Scanner(System.in);

        // open BufferedReader to read server responses.
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // open BufferedWriter to send messages to  the server.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        System.out.println("What do you want to send to the server?");
        String response = scan.nextLine();

        // Write message to the server
        writer.write(response);
        writer.newLine();
        writer.flush(); // ensure data is sent to the server
        System.out.printf("sent to server:\n%s\n", response);

        // Read server response
        String s1 = reader.readLine();
        System.out.printf("received from server:\n%s\n", s1);

        // Close server writer and reader.
        writer.close();
        reader.close();
    }

}
