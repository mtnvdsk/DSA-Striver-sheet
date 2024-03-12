import java.util.HashMap;

public class Solution {
    public static String minSubString(String s, String t) {
        HashMap<Character,Integer> a=new HashMap<>();
        HashMap<Character,Integer> b=new HashMap<>();
        for(int i=0;i<t.length();i++){
            a.put(t.charAt(i),a.getOrDefault(t.charAt(i),0)+1);
        }

        int i=0;
        int n=a.size(),h=0;
        int min=Integer.MAX_VALUE;
        String d="";

        for (int j = 0; j < s.length(); j++) {
            b.put(s.charAt(j), b.getOrDefault(s.charAt(j), 0) + 1);
            if (a.containsKey(s.charAt(j)) && b.get(s.charAt(j)) == a.get(s.charAt(j))) {
                h++;
            }
            while (h == n) {
                if ((j - i + 1) < min) {
                    min = (j - i + 1);
                    d = s.substring(i, j + 1);
                }
                if (a.containsKey(s.charAt(i)) && b.get(s.charAt(i)) > 0) {
                    b.put(s.charAt(i), b.get(s.charAt(i)) - 1);
                    if (b.get(s.charAt(i)) < a.get(s.charAt(i))) {
                        h--;
                    }
                }
                i++;
            }
        }
        return d;
    }
}