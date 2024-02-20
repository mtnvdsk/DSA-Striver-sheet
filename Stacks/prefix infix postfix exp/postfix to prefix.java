import java.util.Stack;

public class Solution {
    public static String postfixToPrefix(String exp) {
        String pre=new String("");
        Stack<String> smb=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char e=exp.charAt(i);
            if(Character.isLetterOrDigit(e)){
                smb.push(Character.toString(e));
            }
            else{
                String op1=smb.pop();
                String op2=smb.pop();
                smb.push(e+op2+op1);
            }
        }
        return smb.pop();
    }
}