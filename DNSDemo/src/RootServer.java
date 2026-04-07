class RootServer {

    public String query(String domain) {
        System.out.println("Root Server: Redirecting to TLD server...");
        return "TLD_SERVER";
    }
}