public class Solution {
    public static int numSubarraysWithSum(int[] nums, int k) {
        int []arr=new int [nums.length+1];
        int res=0;
        arr[0]=1;
        int c=0;

        for(int i=0;i<nums.length;i++){
            c+=nums[i];
            if(c>=k){
                res+=arr[c-k];
            }
            arr[c]++;
        }
        return res;
    }
    public static int distinctSubKOdds(int []arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }
        return numSubarraysWithSum(arr,k);
    }
}
