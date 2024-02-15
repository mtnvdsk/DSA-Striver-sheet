import java.util.Stack;

public class Solution {
    public static int maxDepth(String s) {
        int c=0,a=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') c++;
            else if(s.charAt(i)==')') c--;
            a=Math.max(c,a);
        }
        return a;
    }
}