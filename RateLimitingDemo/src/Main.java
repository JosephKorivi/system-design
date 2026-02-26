public class Main {
    public static void main(String[] args) {
        RateLimitingDemo rateLimitingDemo = new RateLimitingDemo();
        String userId = "testuser";
        for (int i = 0; i < 1005; i++) {
            boolean allowed = rateLimitingDemo.allowRequest(userId);
            if (!allowed) {
                System.out.println("Blocked at request: " + userId);
            }
        }
        System.out.println("Total Usage This Month: " + rateLimitingDemo.getUsage(userId));
    }
}