import java.io.*;
import java.net.*;
import java.util.*;

public class ReverseProxy {

    private static List<String> servers = Arrays.asList(
            "localhost:9001",
            "localhost:9002"
    );

    private static int current = 0;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("Reverse Proxy running on port 8081...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static synchronized String getNextServer() {
        String server = servers.get(current);
        current = (current + 1) % servers.size();
        return server;
    }

    private static void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {
                String backend = getNextServer();
                String[] parts = backend.split(":");

                Socket backendSocket = new Socket(parts[0], Integer.parseInt(parts[1]));

                InputStream clientIn = clientSocket.getInputStream();
                OutputStream clientOut = clientSocket.getOutputStream();

                InputStream backendIn = backendSocket.getInputStream();
                OutputStream backendOut = backendSocket.getOutputStream();

                // Forward request
                clientIn.transferTo(backendOut);

                // Return response
                backendIn.transferTo(clientOut);

                backendSocket.close();
                clientSocket.close();

                System.out.println("Request routed to: " + backend);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}