import java.net.InetAddress;

public class DNSLookup {

    public static void main(String[] args) {
        try {

            InetAddress address = InetAddress.getByName("google.com");

            System.out.println("Domain: google.com");
            System.out.println("IP Address: " + address.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}