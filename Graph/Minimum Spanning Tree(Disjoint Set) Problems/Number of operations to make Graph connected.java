import java.util.ArrayList;

class Disjoint{
    static int[] rank;
    static int[] parent;
    Disjoint(int n){
        rank=new int [n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            rank[i]=0;
            parent[i]=i;
        }
    }
    public int findUPrnt(int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=findUPrnt(parent[u]);
    }
    public void unionByRank(int u,int v){
        int up=findUPrnt(u);
        int vp=findUPrnt(v);
        if(rank[up]<rank[vp]){
            parent[up]=vp;
        }
        else if(rank[vp]<rank[up]){
            parent[vp]=up;
        }
        else{
            parent[vp]=up;
            rank[up]+=1;
        }
    }
}
public class Solution {
    public static int makeGraphConnected(int n, ArrayList<ArrayList<Integer>> edges, int m) {
        Disjoint dj=new Disjoint(n);
        int re=0;
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0)-1;
            int v=edges.get(i).get(1)-1;
            if(dj.findUPrnt(u)==dj.findUPrnt(v)){
                re++;
            }
            else
                dj.unionByRank(u,v);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(dj.parent[i]==i){
                c++;
            }
        }
        int ans=c-1;
        if(re>=ans) return ans;
        return -1;
    }
}