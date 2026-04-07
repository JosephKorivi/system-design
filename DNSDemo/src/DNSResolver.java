class DNSResolver {

    private DNSCache cache = new DNSCache();
    private RootServer root = new RootServer();
    private TLDServer tld = new TLDServer();
    private AuthoritativeServer auth = new AuthoritativeServer();

    public String resolve(String domain) {

        // Step 1: Check Cache
        if (cache.contains(domain)) {
            System.out.println("Cache Hit!");
            return cache.get(domain);
        }

        System.out.println("Cache Miss!");

        // Step 2: Root Server
        root.query(domain);

        // Step 3: TLD Server
        tld.query(domain);

        // Step 4: Authoritative Server
        String ip = auth.query(domain);

        // Step 5: Store in cache
        cache.put(domain, ip);

        return ip;
    }
}