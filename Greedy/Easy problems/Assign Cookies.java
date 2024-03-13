import java.util.*;
public class Solution {
    public static int assignCookie(int []greed, int []size) {
        int n=0;
        Arrays.sort(greed);
        Arrays.sort(size);
        int i=0,j=0;
        while(i<greed.length && j<size.length){
            if(greed[i]<=size[j]){
                n++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return n;
    }

}