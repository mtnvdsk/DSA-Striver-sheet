import java.util.*;

public class Solution 
{
    public static void dfs(int k, int j, int[][] vis, ArrayList<String> temp, int[][] arr, int i1, int j1, int[] drow, int[] dcol){
        vis[k][j] = 1;
        temp.add(coordinatesToString(k - i1, j - j1));
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < 4; i++){
            int row = k + drow[i];
            int col = j + dcol[i];
            if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && arr[row][col] == 1){
                dfs(row, col, vis, temp, arr, i1, j1, drow, dcol);
            }
        }
    }

    public static String coordinatesToString(int a, int b){
        return Integer.toString(a) + " " + Integer.toString(b);
    }

    public static int distinctIsland(int[][] arr, int n, int m) 
    {
        int[][] vis = new int[n][m];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        HashSet<ArrayList<String>> a = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && arr[i][j] == 1){
                    ArrayList<String> temp = new ArrayList<>();
                    dfs(i, j, vis, temp, arr, i, j, drow, dcol);
                    a.add(temp);
                }
            }
        }

        return a.size();
    }
}
