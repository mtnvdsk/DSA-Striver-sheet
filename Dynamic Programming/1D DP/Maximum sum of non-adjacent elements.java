import java.util.* ;

public class Solution {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int dp[] = new int[nums.size()];
        Arrays.fill(dp, -1);
        // tabulation
        // dp[0]=nums.get(0);
        // int neg=0;
        // for(int i=1;i<nums.size();i++){
        //     if(dp[i]!=-1) continue;
        //     int pick=nums.get(i);
        //     if(i>1) pick+=dp[i-2];
        //     int notpick=dp[i-1];
        //     dp[i]=Math.max(pick,notpick);
        // }
        // return dp[nums.size()-1];
        // int res = maxSum(nums, nums.size()-1, dp);
        // return res;

        //space optimization

        int prev=nums.get(0),prev2=0;
        for(int i=0;i<nums.size();i++){
            int take=nums.get(i);
            if(i>1) take+=prev2;
            int nottake=prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;
        }
        return prev;        
    }
	public static int maxSum(List<Integer> nums, int idx, int[] dp){
        if(idx == 0)
            return nums.get(idx);
        if(dp[idx] != -1){ 
            return dp[idx];
        }
        int include = nums.get(idx);
        if(idx > 1)
            include += maxSum(nums, idx-2, dp);
        int notInclude = maxSum(nums, idx-1, dp);
        return dp[idx] = Math.max(include, notInclude);
    }

}