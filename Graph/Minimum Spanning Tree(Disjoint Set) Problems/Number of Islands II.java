import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

 

public class Solution {

    public static int[] numberOfIslandII(int n, int m, int[][] queries, int q) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        int[] ans = new int[q];
        int dr[] = {0, 0, -1, 1};
        int dc[] = {-1, 1, 0, 0};
        for (int i = 0; i < q; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            if (vis[row][col] == 1) {
                ans[i] = cnt;
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (isValid(adjr, adjc, n, m) && (vis[adjr][adjc] == 1)) {
                    int nodeNo = (row * m) + col;
                    int adjNodeNo = (adjr * m) + adjc;
                    if (ds.findParent(nodeNo) != ds.findParent(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
    private static boolean isValid(int row, int col, int n, int m) {
        return ;
    }

}