import java.util.* ;

import java.io.*; 

public class Solution {

    public static long houseRobber(int[] valueInHouse) {

        // Write your code here.    

        if(valueInHouse.length==1)

        return valueInHouse[0];

        long[] dp = new long[valueInHouse.length];

        Arrays.fill(dp, -1);

 

        int[] start = new int[valueInHouse.length-1];

        int[] end = new int[valueInHouse.length-1];

        for(int i=0;i<valueInHouse.length-1;i++){

            start[i]=valueInHouse[i];

            end[i]=valueInHouse[i+1];

        }

 

        // long first = findMax(start, start.length-1,dp);  

        

        // Arrays.fill(dp, -1);

        // long second = findMax(end, end.length-1,dp); 

        

        // return Math.max(first, second);

 

        //Tabulation

        long first = findMax2(start);   

        long second = findMax2(end);    

        return Math.max(first, second);

 

        //Space Optimized

        // long first = findMax3(start);    

        // long second = findMax3(end); 

        // return Math.max(first, second);

 

    }   

    public static long findMax2(int[] houses){

        if(houses.length==1) return houses[0];

        long[] dp = new long[houses.length];

        dp[0] = houses[0];

        dp[1] = Math.max(houses[0], houses[1]);

        for(int i=2; i<houses.length; i++){

            dp[i] = Math.max(dp[i-1], dp[i-2]+houses[i]);

        }

        return dp[houses.length-1];

        

    }

    public static long findMax3(int[] houses){

        long prev1=houses[0];

        long prev2=0;

        for(int i=1; i<houses.length; i++){

            long temp = prev1;

            prev1 = Math.max(prev1, prev2+houses[i]);

            prev2=temp;

        }

        return prev1;

        

    }

    public static long findMax(int[] houses, int pos, long[] dp){

        if(pos<0){

            return 0; 

        }

        if(pos==0){

            return houses[0];

        }

        if(dp[pos]!=-1)

        return dp[pos];

        long inc = 0;

        long exc = 0;

        inc = findMax(houses, pos-2,dp)+houses[pos];

        exc = findMax(houses, pos-1,dp);

        

        return dp[pos] = Math.max(inc, exc);

    }

}