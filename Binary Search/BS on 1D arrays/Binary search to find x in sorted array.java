public class Solution {
    public static int bs(int[] a,int low,int high,int target){
        if(low<=high){
        int m=(low+high)/2;
        if(a[m]==target) return m;
        else if(target<a[m]) return bs(a,low,m-1,target);
        else
        return bs(a,m+1,high,target);
        
    }
    return -1;
    }
    public static int search(int []nums, int target) {
        return bs(nums,0,nums.length-1,target);
    }
}