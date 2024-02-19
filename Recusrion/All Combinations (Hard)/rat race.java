import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> ratMaze(int [][]mat) {
        // Write your code here.
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] checker = new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                checker[i][j] = true;
            }
        }
        List<String> sol = new ArrayList<>();
        getAns(sol, checker, mat, "", 0, 0);
        return sol;
    }
    static void getAns(List<String> ans, boolean[][] checker, int[][] mat, String p, int r, int c){
        if(r == mat.length-1 && c == mat[0].length-1){
            ans.add(p);
            return;
        }

        checker[r][c] = false;

        if(r < mat.length-1 && isSafe(checker, mat, r+1, c)){
            getAns(ans, checker, mat, p+'D', r+1, c);
        }

        if(c < mat[0].length - 1 && isSafe(checker, mat, r, c+1)){
            getAns(ans, checker, mat, p+'R', r, c+1);
        }

        if(r > 0 && isSafe(checker, mat, r-1, c)){
            getAns(ans, checker, mat, p+'U', r-1, c);
        }

        if(c>0 && isSafe(checker, mat, r, c-1)){
            getAns(ans, checker, mat, p+'L', r, c-1);
        }

        checker[r][c] = true;
    }
    
    private static boolean isSafe(boolean[][] checker, int[][] mat, int r, int c){
        if(checker[r][c] == true && mat[r][c] ==1){
            return true;
        }
        return false;
    }
}