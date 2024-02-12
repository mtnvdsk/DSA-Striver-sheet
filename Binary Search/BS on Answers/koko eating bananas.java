import java.util.*;
public class Solution {
    public static int maxnum(int []v){
        int n=v.length;
        int maxval=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxval=Math.max(maxval, v[i]);
        }
        return maxval;
    }
    public static int totalhours(int[]v,int hourly) {
        int ans=0;
        for(int i=0;i<v.length;i++){
            ans+=Math.ceil((double)(v[i])/(double)(hourly));
        }
        return ans;
    }

    public static int minimumRateToEatBananas(int []v, int h) {
        int low=1;
        int high=maxnum(v);
        while(low<=high){
            int mid=(low+high)/2;
            int time=totalhours(v, mid);
            if(time<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}