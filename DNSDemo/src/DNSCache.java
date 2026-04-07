import java.util.HashMap;

class DNSCache {
    private HashMap<String, String> cache = new HashMap<>();

    public void put(String domain, String ip) {
        cache.put(domain, ip);
    }

    public String get(String domain) {
        return cache.get(domain);
    }

    public boolean contains(String domain) {
        return cache.containsKey(domain);
    }
}