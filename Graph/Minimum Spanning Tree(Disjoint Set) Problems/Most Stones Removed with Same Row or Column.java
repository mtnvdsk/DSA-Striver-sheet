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
        return parent.get(node);
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
    public static int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0,maxCol=0;
        for(int i[]:stones){
            maxRow=Math.max(maxRow,i[0]);
            maxCol=Math.max(maxCol,i[1]);
        }
        DisjointSet dj=new DisjointSet(maxCol+maxRow+1);
        HashMap<Integer,Integer> stoneNodes=new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow=stones[i][0];
            int nodeCol=stones[i][1]+maxRow+1;
            dj.unionBySize(nodeRow,nodeCol);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }    
        int c=0;    
        for(Map.Entry<Integer,Integer> it:stoneNodes.entrySet()){
            if(dj.findUPar(it.getKey())==it.getKey()){
                c++;
            }
        }
        return n-c;
    }
}