import java.util.*;
public class Solution {
    public static int countSubStrings(String str, int k) {
         int find = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            int[] charCount = new int[26];
            for (int j = i; j < str.length(); j++) {
                int charIndex = str.charAt(j) - 'a';
                if (charCount[charIndex] == 0) {
                    charCount[charIndex]++;
                    count++;
                }
                if (count == k) {
                    find++;
                } else if (count > k) {
                    break;
                }
            }
        }
        return find;
    }
}