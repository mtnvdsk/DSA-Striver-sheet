public class Solution {
    public static int max(int[] a){
        int h=Integer.MIN_VALUE;
        for(int i:a)
        h=Math.max(h,i);
        return h;
    }
    public static boolean verify(int[] a,int m,int limit){
        int s=0;
        for(int i:a)
        s+=Math.ceil((double)i/m); 
        return s<=limit;
    }
    public static int bs(int []a,int l){
        int low=1;
        int high=max(a);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(verify(a,mid,l)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static int smallestDivisor(int arr[], int limit) {
        return bs(arr,limit);
    }
}