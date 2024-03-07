import java.util.*;
public class Solution {
    public static void immediateSmaller(int []a) {
        Stack<Integer> temp=new Stack<>();
        int n=a.length;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                temp.add(a[i]);
                a[i]=-1;
                continue;
            }
            else{
                int b=temp.peek();
                int c=a[i];
                if(b>a[i]){
                    a[i]=-1;
                }
                else{
                    a[i]=b;
                }
                temp.add(c);
            }
        }
    }
}
