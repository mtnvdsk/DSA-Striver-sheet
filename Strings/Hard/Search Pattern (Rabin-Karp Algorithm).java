import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int d = 256;
    private static final int q = 101;
    public static List< Integer > stringMatch(String text, String pattern){
        int p=0;
        int t=0;
        int h=1;
        int n=text.length();
        int m=pattern.length();
        List<Integer> a=new ArrayList<>();
        if(pattern.length()>text.length()) return a;
        int i,j;
        for(i=0;i<m-1;i++){
            h=(h*d)%q;
        }
        for(i=0;i<m;i++){
            p=(p*d+pattern.charAt(i))%q;
            t=(t*d+text.charAt(i))%q;
        }
        for (i = 0; i <= n - m; i++) {
            int c = 0;
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    a.add(i+1);
                }
            }
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0)
                    t = t + q;
            }

        }
        return a;
    }
}