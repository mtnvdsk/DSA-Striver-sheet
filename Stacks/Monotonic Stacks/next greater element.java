import java.util.Stack;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
          int curr=arr[i];
          while(!st.isEmpty() && st.peek()<=curr) st.pop();
          if(st.isEmpty()) arr[i]=-1;
          else arr[i]=st.peek();
          st.push(curr);
        }
        return arr;
    }
}
