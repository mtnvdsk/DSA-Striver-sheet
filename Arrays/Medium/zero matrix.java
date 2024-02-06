import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        boolean[][] v = new boolean[n][m]; // Reverse the dimensions

        for (int i = 0; i < n; i++) { // Reversed iteration
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    v[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) { // Reversed iteration
            for (int j = 0; j < m; j++) {
                if (v[i][j]) {
                    for (int k = 0; k < n; k++) {
                        matrix.get(k).set(j, 0);
                    }
                    for (int k = 0; k < m; k++) {
                        matrix.get(i).set(k, 0);
                    }
                }
            }
        }

        return matrix;
    }
}
