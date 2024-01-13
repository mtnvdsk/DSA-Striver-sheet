import java.util.*;
public class Solution {
    private static final int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public static int minimumTime(int n, int [][]grid) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            int[] a = pq.poll();
            for(int[] d: dir) {
                int x = a[0] + d[0], y = a[1] + d[1];
                if(x < 0 || x >= n || y < 0 || y >= n) continue;
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    int t = Math.max(a[2], grid[x][y]);
                    if(x == n-1 && y == n-1) return t;
                    pq.add(new int[] {x, y, t});
                }
            }
        }
        return 0;
    }
}