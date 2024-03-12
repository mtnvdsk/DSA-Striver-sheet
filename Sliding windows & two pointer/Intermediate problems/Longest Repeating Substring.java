import java.util.HashMap;

public class Solution {
    public static int longestRepeatingSubstring(String str, int k) {
        int n = str.length();
        int w_s = 0;
        int c = 0;
        int max = 0;
        HashMap<Character, Integer> lfm = new HashMap<>();

        for (int w_e = 0; w_e < n; w_e++) {
            char r_c = str.charAt(w_e);
            lfm.put(r_c, lfm.getOrDefault(r_c, 0) + 1);
            c = Math.max(c, lfm.get(r_c));

            if (w_e - w_s + 1 - c > k) {
                char l_c = str.charAt(w_s);
                lfm.put(l_c, (lfm.get (l_c) - 1));
                w_s++;
            }

         max = Math.max(max, w_e - w_s + 1);
        }

        return max;
    }
}