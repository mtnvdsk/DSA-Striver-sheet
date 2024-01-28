public class Solution {
    public static int maximumProfit(int[] values, int n, int fee) {
        int[] ahead=new int[2];
        ahead[0]=ahead[1]=0;
        for (int i = n - 1; i >= 0; i--) {
            int[] curr=new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit=0;
                if (buy==1) {
                    profit = Math.max(-values[i] + ahead[0], ahead[1]);
                } else {
                    profit = Math.max(values[i]-fee+ ahead[1], ahead[0]);
                }
                curr[buy]=profit;
            }
            ahead=curr;
        }
        return ahead[1];
    }
}
