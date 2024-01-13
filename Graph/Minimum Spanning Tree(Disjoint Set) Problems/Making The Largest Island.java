import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class Solution {
    public static int maximumIslandSize(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        DisjointSet dj = new DisjointSet(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int newr = i + drow[k];
                        int newcol = j + dcol[k];
                        if (newr >= 0 && newr < n && newcol >= 0 && newcol < m && grid[newr][newcol] == 1) {
                            int adjnodeno = newr * m + newcol;
                            int nodeno = i * m + j;
                            dj.unionBySize(adjnodeno, nodeno);
                        }
                    }
                }
            }
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> comp = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newr = i + drow[k];
                        int newcol = j + dcol[k];
                        if (newr >= 0 && newr < n && newcol >= 0 && newcol < m && grid[newr][newcol] == 1) {
                            comp.add(dj.findUPar(newr * m + newcol));
                        }
                    }
                    int size = 0;
                    for (Integer parents : comp) {
                        size += dj.size.get(parents);
                    }
                    mx = Math.max(mx, size + 1);
                }
            }
        }

        for (int i = 0; i < n * m; i++) {
            mx = Math.max(mx, dj.size.get(i));
        }
        return mx;
    }
}
