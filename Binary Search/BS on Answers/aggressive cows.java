import java.util.*;
public class Solution {
    public static boolean verify(int[] a,int k,int mid){
        int c=1,last=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]-last>=mid){
                c++;
                last=a[i];
            }
        }
        return c>=k;
    }
    public static int bs(int[] a,int k){
        int low=1;
        int high=a[a.length-1]-a[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(verify(a,k,mid)) low=mid+1;
            else high=mid-1;
        }
        return high;
    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        return bs(stalls,k);
    }
}