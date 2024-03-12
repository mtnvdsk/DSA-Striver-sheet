public class Solution {
    public static int countSubstring(String s){
        int ans = 0;
        int n = s.length();
        int aIdx = -1, bIdx = -1, cIdx = -1;
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == 'a')
            {
                aIdx = i;
            }
            else if (s.charAt(i) == 'b')
            {
                bIdx = i;
            }
            else if (s.charAt(i) == 'c')
            {
                cIdx = i;
            }

            int minIdx = Math.min(aIdx, Math.min(bIdx, cIdx));
            ans = ans + (minIdx + 1);
        }
        return ans;
    }
}