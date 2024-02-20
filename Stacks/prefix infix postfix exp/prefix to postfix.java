import java.util.*;
public class Solution {
    public static String preToPost(String s) {
     String pst=new String("");
     Stack<String> c=new Stack<>();
     for(int i=s.length()-1;i>=0;i--){
         char e=s.charAt(i);
         if(Character.isLetterOrDigit(e)){
             c.push(Character.toString(e));
         }
         else{
             String op1=c.pop();
             String op2=c.pop();
             c.push(op1+op2+e);
         }
     }
     return c.pop();
    }
}