import java.util.*;
public class Solution {
    public static int[] findStockSpans(int []prices) {
        int n=prices.length;
        Stack<Integer> a=new Stack<>();
        int []ss=new int[n];
        for(int i=0;i<n;i++){
            while(!a.isEmpty() && prices[a.peek()]<prices[i]){
                a.pop();
            }
            if(a.isEmpty()){
                ss[i]=i+1;
            }
            else ss[i]=i-a.peek();
            a.push(i);
        }
        return ss;
    }
}