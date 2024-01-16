import java.util.*;

public class Solution {
    public static void countDistinctSubsequences(String s, int index, String current, Set<String> distinctSubsequences) {
        if (index == s.length()) {
            distinctSubsequences.add(current);
            return;
        }
        countDistinctSubsequences(s, index + 1, current + s.charAt(index), distinctSubsequences);
        countDistinctSubsequences(s, index + 1, current, distinctSubsequences);
        
    }

    public static String moreSubsequence(int n, int m, String a, String b) {
        Set<String> as=new HashSet<>();
        Set<String> bs=new HashSet<>();
        countDistinctSubsequences(a, 0, "", as);
        countDistinctSubsequences(b, 0, "", bs);

        if (as.size() >=bs.size()) {
            return a;
        } else {
            return b;
        }
    }
}

//Solution 2
import java.util.HashMap;
class Solution {
    public static int func(String s, int n) {
        // Initializing 'count' with 1.
        int count = 1;

        // Creating a HashMap of [char, int] 'm1'.
        HashMap<Character, Integer> m1 = new HashMap<>();

        // Calculating number of distinct subsequences.
        for (int i = 0; i < n; i++) {
            if (!m1.containsKey(s.charAt(i))) {
                m1.put(s.charAt(i), count);
                count *= 2;
            } else {
                int temp = m1.get(s.charAt(i));
                m1.put(s.charAt(i), count);
                count *= 2;
                count -= temp;
            }
        }
        return count;
    }

    public static String moreSubsequence(int n, int m, String a, String b) {
        if (func(a, n) >= func(b, m)) {
            return a;
        } else {
            return b;
        }
    }
}