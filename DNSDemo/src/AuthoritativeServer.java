import java.util.HashMap;

class AuthoritativeServer {

    private HashMap<String, String> records = new HashMap<>();

    public AuthoritativeServer() {
        records.put("google.com", "142.250.183.14");
        records.put("github.com", "140.82.114.4");
    }

    public String query(String domain) {
        System.out.println("Authoritative Server: Returning IP...");
        return records.getOrDefault(domain, "NOT_FOUND");
    }
}