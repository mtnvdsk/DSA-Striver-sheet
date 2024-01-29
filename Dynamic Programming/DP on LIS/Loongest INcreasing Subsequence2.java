import java.util.*;
public class Solution 
{
	private static int rec(int arr[], int prevPosition, int curPosition, int n, int[][] dp) 
	{
		if (curPosition == n) 
		{
			return 0;
		}
		if (dp[prevPosition + 1][curPosition] >= 0) 
		{
			return dp[prevPosition + 1][curPosition];
		}
		int taken = 0;
		if (prevPosition < 0 || arr[curPosition] > arr[prevPosition]) 
		{
			taken = 1 + rec(arr, curPosition, curPosition + 1, n, dp);
		}
		int notTaken = rec(arr, prevPosition, curPosition + 1, n, dp);
		return dp[prevPosition + 1][curPosition] = Math.max(taken, notTaken);
	}

	public static int longestIncreasingSubsequence(int arr[]) 
	{
		int n = arr.length;
		// int[][] dp = new int[n + 1][n + 1];
		// for (int i[]:dp) Arrays.fill(i,-1);
		// int ans = rec(arr, -1, 0, n, dp);
		// return ans;
		// int n = arr.length;
		// int[] dp=new int[n];
		// Arrays.fill(dp,1);
		// int max=1;
		// for(int i=0;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(arr[j]<arr[i]){
        //             dp[i]=Math.max(dp[i],1+dp[j]);
        //         }
        //     }
        //     max=Math.max(max,dp[i]);
		// }
		// return max;

		//binary search
		List<Integer> temp=new ArrayList<>();
		temp.add(arr[0]);
		int len=1;
		for(int i=1;i<n;i++){
			if(arr[i]>temp.get(temp.size()-1)){
				temp.add(arr[i]);
				len++;
			}
			else{
				int ind=Collections.binarySearch(temp,arr[i]);
				if (ind < 0) {
                    ind = -ind - 1;
                }
				temp.set(ind,arr[i]);
			}
		}
		return len;
	}

}