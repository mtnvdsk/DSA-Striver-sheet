import java.util.Stack;

public class Solution {
    public static boolean isValidParenthesis(String s) {
        Stack<Character> valid = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                valid.push(s.charAt(i));
            } else {
                if (valid.isEmpty()) {
                    return false; // Unmatched closing parenthesis, no corresponding opening parenthesis
                }

                char top = valid.pop();
                if (s.charAt(i) == '}' && top != '{') {
                    return false;
                } else if (s.charAt(i) == ')' && top != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && top != '[') {
                    return false;
                }
            }
        }

        return valid.isEmpty(); // Return true if the stack is empty (all parentheses matched)
    }
}
