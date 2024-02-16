import java.util.HashSet;

public class Solution {
    public static boolean areIsomorphic(String str1, String str2) {
        HashSet<Character> a=new HashSet<>();
        HashSet<Character> b=new HashSet<>();
        if(str1.length()>str2.length() || str2.length()>str2.length()) return false;
        for(int i=0;i<str1.length();i++){
            a.add(str1.charAt(i));
            b.add(str2.charAt(i));
        }
        if(a.size()==b.size()) return true;
        else{
            return false;
        }
    }
}