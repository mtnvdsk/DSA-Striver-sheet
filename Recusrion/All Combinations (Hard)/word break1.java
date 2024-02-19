import java.util.*;
public class Solution {
    public static List< String > getAllValidSentences(String s, String []dict) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        generateSentences(0, s, dict, temp, ans);
        return ans;
    }
    public static void generateSentences(int ind, String s, String[] dict, List<String> temp, List<String> ans){
        if(ind == s.length()){
            String finalString = String.join(" ", temp);
            ans.add(finalString);
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(isPresent(dict, s.substring(ind, i+1))){
                temp.add(s.substring(ind, i+1));
                generateSentences(i+1, s, dict, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isPresent(String[] dict, String s) {
    for (String str : dict) {
        if (str.equals(s)) {
            return true;
        }
    }
    return false;
}
}