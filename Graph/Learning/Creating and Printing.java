package Learning;
import java.util.*;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<List<Integer>> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
            a.get(i).add(i);
        }
        for(int k[]:edges){
            int u=k[0];
            int v=k[1];
            a.get(u).add(v);
            a.get(v).add(u);
        }
        int [][] r=new int[n][];
        for(int i=0;i<n;i++){
            r[i]=a.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return r;
    }
}