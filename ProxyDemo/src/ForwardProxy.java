import java.io.*;
import java.net.*;

public class ForwardProxy {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Forward Proxy running on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {
                BufferedReader clientIn = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                OutputStream clientOut = clientSocket.getOutputStream();

                String requestLine = clientIn.readLine();
                System.out.println("Client Request: " + requestLine);

                // Example: GET http://example.com HTTP/1.1
                String urlString = requestLine.split(" ")[1];
                URL url = new URL(urlString);

                Socket serverSocket = new Socket(url.getHost(), 80);

                PrintWriter serverOut = new PrintWriter(serverSocket.getOutputStream(), true);
                BufferedReader serverIn = new BufferedReader(
                        new InputStreamReader(serverSocket.getInputStream()));

                serverOut.println("GET " + url.getPath() + " HTTP/1.1");
                serverOut.println("Host: " + url.getHost());
                serverOut.println("Connection: close");
                serverOut.println();

                String line;
                while ((line = serverIn.readLine()) != null) {
                    clientOut.write((line + "\n").getBytes());
                }

                serverSocket.close();
                clientSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}