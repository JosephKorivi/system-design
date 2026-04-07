public class Main {
    public static void main(String[] args) {

        DNSResolver resolver = new DNSResolver();

        System.out.println("First Request:");
        System.out.println("IP: " + resolver.resolve("google.com"));

        System.out.println("\nSecond Request:");
        System.out.println("IP: " + resolver.resolve("google.com"));
    }
}