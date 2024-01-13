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
class Solution{
    public static int noOfIslands(int [][]adj,int n){
        Disjoint dj=new Disjoint(n);
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[0].length;j++){
                if(adj[i][j]==1)
                    dj.unionByRank(i, j);
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(dj.findUPrnt(i)==i){
                c++;
            }
        }
        return c;
    }
}