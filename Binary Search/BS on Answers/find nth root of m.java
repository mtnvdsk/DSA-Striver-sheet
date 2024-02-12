public class Solution {
    public static int NthRoot(int n, int m) {
        int low=0;
        int high=m;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(mid,n)==m) return mid;
            else if (Math.pow(mid,n)>m) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}
