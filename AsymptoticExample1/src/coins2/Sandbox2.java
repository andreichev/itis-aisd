package coins2;

import java.util.HashMap;
import java.util.Map;

public class Sandbox2 {
    // 1 5 10 20 25 50
    static Map<String, Integer> variants = new HashMap<>();

    static void enumerate(String line, int coinsCount, int sum, int target) {
        if(sum == target) {
            variants.put(line, coinsCount);
        }
        if(sum >= target) { return; }
        enumerate(line + " 1", coinsCount + 1, sum + 1, target);
        enumerate(line + " 5", coinsCount + 1, sum + 5, target);
        enumerate(line + " 10", coinsCount + 1, sum + 10, target);
        enumerate(line + " 20", coinsCount + 1, sum + 20, target);
        enumerate(line + " 25", coinsCount + 1, sum + 25, target);
        enumerate(line + " 50", coinsCount + 1, sum + 50, target);
    }

    public static void main(String[] args) {
        enumerate("", 0, 0, 42);

        int minCoinsCount = Integer.MAX_VALUE;
        String bestVariant = null;
        for(Map.Entry<String, Integer> entry : variants.entrySet()) {
            if(entry.getValue() < minCoinsCount) {
                minCoinsCount = entry.getValue();
                bestVariant = entry.getKey();
            }
        }

        System.out.println(bestVariant);
    }
}
