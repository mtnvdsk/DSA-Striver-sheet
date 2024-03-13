import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int k) {
        List<Integer> rc=new ArrayList<>();
        int []coins={1,2,5,10,20,50,100,500,1000};
        int n=coins.length;
        for(int i=n-1;i>=0;i--){
            while(k>=coins[i]){
                k-=coins[i];
                rc.add(coins[i]);
            }
        }
        return rc;
    }
}