import java.util.*;
import java.io.*;
public class Solution {
  public static int findMinimumCost(String str) {
    Stack < Character > stack = new Stack < > ();
    int openingBrackets = 0; // in stack
    int closingBrackets = 0; // in stack
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '{') {
        stack.push('{');
        openingBrackets++;
      } else {
        if (stack.size() > 0 && stack.peek() == '{') {
          stack.pop();
          openingBrackets--;
        } else {
          //stack.push('}');
          closingBrackets++;
        }
      }
    }
    if ((closingBrackets + openingBrackets) % 2 != 0) {
      return -1;
    } else {
      return closingBrackets / 2 + openingBrackets / 2 + 2 * (openingBrackets % 2);
    }
  }
}