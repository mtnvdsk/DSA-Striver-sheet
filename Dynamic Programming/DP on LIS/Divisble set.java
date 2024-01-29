import java.util.*;
public class Solution {
    public static List< Integer > divisibleSet(int []arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<Integer> temp=new ArrayList<>();
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int ans=-1;
        int lastindex=-1;
        for(int i=0;i<n;i++){
            if(dp[i]>ans){
                ans=dp[i];
                lastindex=i;
            }
        }
        temp.add(arr[lastindex]);
        while(hash[lastindex]!=lastindex){
            lastindex=hash[lastindex];
            temp.add(arr[lastindex]);
        }
        Collections.reverse(temp);
        return temp;
    }
}