import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int min=prices.get(0);
        int profit=0;
        int n=prices.size();
        for(int i=1;i<n;i++){
            int ans=prices.get(i)-min;
            profit=Math.max(profit,ans);
            min=Math.min(min,prices.get(i));
        }
        return profit;
    }
}