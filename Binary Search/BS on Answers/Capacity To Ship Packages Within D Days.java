import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean verify(int[] a,int d,int mid){
        int total=0,days=1;
        for(int i=0;i<a.length;i++){
            if(total+a[i]>mid){
                days++;
                total=a[i];
            }
            else{
                total+=a[i];
            }
        }
        if(days<=d) return true;
        return false;
    }
    public static int bs(int[] a,int d){
        int low=Arrays.stream(a).max().getAsInt();
        int high=Arrays.stream(a).sum();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(verify(a,d,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static int leastWeightCapacity(int[] weights, int d) {
        return bs(weights,d);
    }
}