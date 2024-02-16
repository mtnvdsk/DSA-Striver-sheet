import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int sumOfBeauty(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j++) {
                Map<Character, Integer> counter = countCharacters(s.substring(i, j + 1));
                int maxCount = getMaxCount(counter);
                int minCount = getMinCount(counter);
                res += (maxCount - minCount);
            }
        }

        return res;
    }

    private static Map<Character, Integer> countCharacters(String substring) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : substring.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    private static int getMaxCount(Map<Character, Integer> counter) {
        int maxCount = Integer.MIN_VALUE;
        for (int count : counter.values()) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private static int getMinCount(Map<Character, Integer> counter) {
        int minCount = Integer.MAX_VALUE;
        for (int count : counter.values()) {
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}
