public class Solution {
    public static int firstOccurence(String text, String pat){
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pat.charAt(k)) {
                k++;
            } else {
                i=i-k;
                k = 0;
            }
            if (k == pat.length()) {
                return i - pat.length()+1;
            } 
        }
        return -1;
    }
}
