import java.util.*;

class pair{
    int i,j;
    pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class pairs{
    int i,j,k;
    pairs(int i,int j,int k){
        this.i=i;
        this.j=j;
        this.k=k;
    }
}
public class Solution {
    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<trains.size();i++){
            adj.get(trains.get(i).get(0)).add(new pair(trains.get(i).get(1),trains.get(i).get(2)));
        }
        Queue<pairs> q=new LinkedList<>();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        ans[source]=0;
        q.add(new pairs(source,0,0));
        while(!q.isEmpty()){
            int node=q.peek().i;
            int stop=q.peek().j;
            int dist=q.peek().k;
            q.remove();
            if(stop>k) continue;
            for(pair it: adj.get(node)){
                int adjnode=it.i;
                int adjdist=it.j;

                if(dist+adjdist<ans[adjnode] && stop<=k){
                    ans[adjnode]=dist+adjdist;
                    q.add(new pairs(adjnode,stop+1,ans[adjnode]));
                }
            }
        }
        if(ans[destination]==Integer.MAX_VALUE) return -1;
        return ans[destination];
    }
}