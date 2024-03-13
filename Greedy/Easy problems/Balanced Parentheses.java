import java.util.*;
public class Solution {
    public static boolean isBalanced(String b){
        Stack<Character> balance=new Stack<>();
        char[] S=b.toCharArray();
        for(char i:S){
            if(i=='(' || i=='{' || i=='['){
                balance.add(i);
            }
            if(balance.isEmpty()) return false;
            if(balance.peek()=='[' && i==']'){
                balance.pop();
            }
            else if(balance.peek()=='{' && i=='}'){
                balance.pop();
            }
            else if(balance.peek()=='(' && i==')'){
                balance.pop();
            }
        }
        if(balance.isEmpty()) return true;
        return false;
    }
}