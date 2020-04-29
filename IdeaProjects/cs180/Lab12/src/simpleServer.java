import java.io.*;
import java.net.*;


public class simpleServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create server socket.
        ServerSocket serverSocket = new ServerSocket(4242);

        // Accept client connection.
        System.out.println("Waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Open BufferedReader to read client input.
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Open BufferedWriter to send responses to the client.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();  // ensure data is sent to the client

        // Read client message.
        String message = reader.readLine();
        System.out.printf("received from client:\n%s\n", message);

        // Process Message
        String response = message.replaceAll(" ",",");

        // Send response to the client.
        writer.write(response);
        writer.newLine();
        writer.flush();  // Ensure data is sent to the client.
        System.out.printf("sent to client:\n%s\n", response);

        // Close client writer and reader.
        writer.close();
        reader.close();
    }

}
