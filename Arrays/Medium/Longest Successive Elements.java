import java.util.Arrays;
import java.util.Collections;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        int m=1,c=1;
        Arrays.sort(a);
        for(int i=1;i<a.length;i++){
            if(a[i]-a[i-1]==1){
                c++;
            }
            else if(a[i]!=a[i-1]){
                c=1;
            }
            m=Math.max(c,m);
        }
        return m;
    }
}