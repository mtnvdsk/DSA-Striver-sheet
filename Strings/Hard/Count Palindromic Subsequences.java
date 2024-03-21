import java.util.ArrayList;

public class Solution
{
    private static int mod = 1000000000 + 7;

    //    Returns the number of palindromic subsequences in the subString [i: j] of String 'S'.
    public static int countPalindromicSubsequencesHelper(int i, int j, String s, ArrayList<ArrayList<Integer>> dp)
    {
        if (i > j)
        {
            //    Invalid subString.
            return 0;
        }
        else if (i == j)
        {
            //    Every single character in the String is a palindrome itself.
            return 1;
        }
        else if (dp.get(i).get(j) != -1)
        {
            //    Solution already exists.
            return dp.get(i).get(j);
        }
        else if (s.charAt(i) == s.charAt(j))
        {
            int ans = (1 + countPalindromicSubsequencesHelper(i + 1, j, s, dp) + countPalindromicSubsequencesHelper(i, j - 1, s, dp)) % mod;

            //    Store the results in dp matrix.
            dp.get(i).set(j, ans);

            return ans;
        }
        else
        {
            int ans = ((countPalindromicSubsequencesHelper(i + 1, j, s, dp) + countPalindromicSubsequencesHelper(i, j - 1, s, dp)) % mod - countPalindromicSubsequencesHelper(i + 1, j - 1, s, dp) + mod) % mod;

            //    Store the results in the dp matrix;
            dp.get(i).set(j, ans);

            return ans;
        }
    }

    public static int countPalindromicSubseq(String s)
    {
        int n = s.length();

        //    DP matrix to store the number of palindromic subsequences in subString [i, j] of the given String 'S'.
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n; i++)
        {
            dp.add(new ArrayList<Integer>(n));
            for (int j = 0; j < n; j++)
            {
                dp.get(i).add(-1);
            }
        }

        return countPalindromicSubsequencesHelper(0, n - 1, s, dp);
    }
}