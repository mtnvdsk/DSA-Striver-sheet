public class Solution {
    public static int[] alternateNumbers(int []nums)  {
        // Write your code here.
        int n= nums.length;
     
        int ans[]= new int[n];

        int posIndex=0, negIndex=1;

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){

            ans[posIndex]= nums[i];
            posIndex+=2;
            }
           
            else{

             ans[negIndex]=nums[i];
             negIndex+=2;
            }
        }
        return ans;
    }
}

