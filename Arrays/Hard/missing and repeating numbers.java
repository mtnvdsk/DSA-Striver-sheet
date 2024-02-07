import java.util.*;
public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        Arrays.sort(a);
        int s=0,m=0,sum=0,sq=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            sq+=a[i]*a[i];
        }
        int n= a.length*(a.length+1)/2;
        int n2=(a.length * (a.length + 1) * (2 * a.length + 1)) / 6
        s=
        m=n-(sum-s);
        return new int[]{,m};
    }
}