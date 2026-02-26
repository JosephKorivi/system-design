import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Received from client: " + message);

            output.println("Hello Client, message received!");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}