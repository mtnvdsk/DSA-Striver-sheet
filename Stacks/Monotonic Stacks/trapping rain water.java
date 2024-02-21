import java.util.*;

public class Solution {
    public static long getTrappedWater(long[] arr,int n) {
        long result=0;
        long leftmax=0,rightmax=0;
        int l=0,r=n-1;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(arr[l]>leftmax) leftmax=arr[l];
                else result+=leftmax-arr[l];
                l++;
            }
            else{
                if(arr[r]>=rightmax) rightmax=arr[r];
                else result+=rightmax-arr[r];
                r--;
            }
        }
        return result;
    }
}


//using stack
class Solution { 
    public static int maxWater(int[] height) 
    { 
        Stack<Integer> stack = new Stack<>(); 
        int n = height.length; 
        int ans = 0; 
        for (int i = 0; i < n; i++) { 
            while ((!stack.isEmpty()) 
                   && (height[stack.peek()] < height[i])) { 
                int pop_height = height[stack.peek()]; 
                stack.pop(); 
                if (stack.isEmpty()) 
                    break; 
                int distance = i - stack.peek() - 1; 
                int min_height 
                    = Math.min(height[stack.peek()], 
                               height[i]) 
                      - pop_height; 
  
                ans += distance * min_height; 
            } 
            stack.push(i); 
        } 
  
        return ans; 
    }
}