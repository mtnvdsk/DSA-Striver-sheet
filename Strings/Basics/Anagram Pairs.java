import java.util.*;
public class Solution {

    public static boolean isAnagram(String str1, String str2) {
        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    } 
}