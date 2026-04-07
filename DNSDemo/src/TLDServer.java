class TLDServer {

    public String query(String domain) {
        System.out.println("TLD Server: Redirecting to Authoritative server...");
        return "AUTH_SERVER";
    }
}