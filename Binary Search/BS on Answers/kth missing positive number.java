import java.util.*;
public class Solution {
    public static int bs(int[] a,int k){
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=a[mid]-(mid+1);
            if(missing>=k) high=mid-1;
            else low=mid+1;
        }
        return k+ high + 1;
    }
    public static int missingK(int[] vec, int n, int k) {
        return bs(vec,k);
    }
}