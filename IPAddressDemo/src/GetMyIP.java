import java.net.InetAddress;

public class GetMyIP {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();

            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}