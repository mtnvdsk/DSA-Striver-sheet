import java.util.*;
public class Solution {
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int j=-1;
        int n=A.size();
        for(int i=n-2;i>=0;i--){
            if(A.get(i)<A.get(i+1)){
                j=i;
                break;
            }
        }
        if(j==-1){
            Collections.reverse(A);
            return A;
        }

        for (int i = n - 1; i > j; i--) {
            if (A.get(i) > A.get(j)) {
                int tmp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, tmp);
                break;
            }
        }
        List<Integer> a=A.subList(j+1, n);
        Collections.reverse(a);
        return A;
    }
}