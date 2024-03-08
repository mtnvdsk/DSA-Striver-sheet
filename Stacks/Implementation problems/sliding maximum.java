import java.util.*;
public class Solution {
	public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        // Write your code here.
        Deque<Integer> d=new ArrayDeque<>();
        int ans[]=new int[n-k+1],j=0;
        for(int i=0;i<n;i++){
          if(!d.isEmpty() && d.peek()==i-k) d.poll();
          while(!d.isEmpty() && arr[d.peekLast()]<arr[i]) d.pollLast();
          d.offer(i);
          if(i>=k-1) ans[j++]=arr[d.peek()];
        }
        return ans;
	}
}