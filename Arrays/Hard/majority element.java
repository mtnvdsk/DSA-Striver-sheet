import java.util.*;
public class Solution {
    public static List< Integer > majorityElement(int []v) {
        Arrays.sort(v);
        int n=v.length;
        List<Integer> a=new ArrayList<>();
        int c=0;
        for (int i = 0; i < n; i++) {
            c++;
            if (i == n - 1 || v[i] != v[i + 1]) {
                if (c > n / 3) {
                    a.add(v[i]);
                }
                c = 0;
            }
        }
        return a;
    }
}