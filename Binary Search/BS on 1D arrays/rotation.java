public class Solution {
    public static int findKRotation(int []arr){
        int low=0;
        int right=arr.length-1;
        int index=-1;
        int ans=Integer.MAX_VALUE;
        while(low<=right){
            int mid=(low+right)/2;
            if(arr[mid]<ans){
                ans=arr[mid];
                index=mid;
            }
            if(arr[mid]<arr[right]){
                right=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
}