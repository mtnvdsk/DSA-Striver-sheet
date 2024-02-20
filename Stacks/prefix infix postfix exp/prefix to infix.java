import java.util.*;

public class Solution {
    public static String prefixToInfixConversion(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }

        return stack.pop();
    }
}
