import java.util.*;

public class Solution {
    public static int prec(char c){
        switch (c){
            case '^':return 3;
            case '/':
            case '*':return 2;
            case '+':
            case '-':return 1;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        String postfix = new String("");
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                postfix+=c;
            }
            else if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix+=stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && prec(c)<=prec(stack.peek())){
                    postfix+=stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                postfix += stack.pop();
             }
        return postfix;
    }
}
