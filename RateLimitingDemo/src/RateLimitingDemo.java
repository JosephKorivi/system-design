// importing the packages

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class RateLimitingDemo {

    private static final int LIMIT = 1000;

    private Map<String, Integer> map = new HashMap<>();
    public boolean allowRequest(String userId) {
        String month = YearMonth.now().toString();
        String key = userId + "_" + month;
        int count = map.getOrDefault(key, 0);
        if (count >= LIMIT) {
            return false;
        }
        map.put(key, count + 1);
        return true;
    }

    public int getUsage(String userId) {
        String month = YearMonth.now().toString();
        String key = userId + "_" + month;
        return map.getOrDefault(key, 0);
    }
}
