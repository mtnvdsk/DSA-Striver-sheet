import java.util.*;
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}


public class Solution {
    
    public static int kruskalMST(int n,int [][]edges) {
        DisjointSet ds=new DisjointSet(n);
        Arrays.sort(edges, (x, y) -> x[2] - y[2]);
        int ans=0;
        for(int i=0;i<edges.length;i++){
            int wt=edges[i][2];
            int src=edges[i][0];
            int dest=edges[i][1];
            if(ds.findUPar(src)!=ds.findUPar(dest)){
                ans+=wt;
                ds.unionByRank(src,dest);
            }
        }
        return ans;
    }
}