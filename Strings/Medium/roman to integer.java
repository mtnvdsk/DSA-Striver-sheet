import java.util.HashMap;

public class Solution {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        int result = 0;
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int currentNum = romanMap.get(s.charAt(i));
            if (i < n - 1) {
                int nextNum = romanMap.get(s.charAt(i + 1));
                if (currentNum < nextNum) {
                    result += (nextNum - currentNum);
                    i++; // Skip the next numeral since it has been considered
                    continue;
                }
            }
            result += currentNum;
        }
        return result;
    }
}
