public class Solution {
    public static int bestTimeToBuyAndSellStock(int[] prices) {
        int m=prices[0];
        int p=0;
        for(int i=1;i<prices.length;i++){
            int a=prices[i]-m;
            p=Math.max(p,a);
            m=Math.min(m,prices[i]);
        }
        return p;
    }
}
