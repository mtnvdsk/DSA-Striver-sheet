import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElementII(int []a) {
        Stack<Integer> nge=new Stack<>();
        int n=a.length;
        for(int i=(2*n)-1;i>=0;i--){
            int num=a[i%n];
            while(!nge.isEmpty() && num>=nge.peek()){
                nge.pop();
            }
            
            if(i<n){
            if(nge.isEmpty()) a[i]=-1;
            else a[i]=nge.peek();}
            nge.push(num);
        }
        return a;
    }
}
