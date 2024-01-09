import java.util.*;


public class Solution {

    static class pair{
        int parent;
        int node;
        pair(int parent,int node){
            this.parent=parent;
            this.node=node;
        }
    }    
    static class Graph {
        boolean dfs(int i,int parent,int[] vis,List<List<Integer>> adj){
            vis[i]=1;
            for(int j:adj.get(i)){
                if(vis[j]==0){
                    if(dfs(j,i,vis,adj)) return true;
                }
                else if(parent!=j) return true;
            }
            return false;
        }
        boolean bfs(int i,int[] vis,List<List<Integer>> adj){
            vis[i]=1;
            Queue<pair> temp=new LinkedList<pair>();
            temp.add(new pair(-1,i));
            while(!temp.isEmpty()){
                int node=temp.peek().node;
                int parent=temp.peek().parent;
                temp.remove();
                List<Integer> a=adj.get(node);
                for(int j:a){
                    if(vis[j]==0){
                        vis[j]=1;
                        temp.add(new pair(node,j));
                    }
                    else if(parent!=j) return true;
                }
            }
            return false;
        }
        boolean detectCycle(int v, List<List<Integer>> adj) {
            int[] vis=new int[v];
            for(int i=0;i<v;i++){
                if(vis[i]==0)
                if(bfs(i,vis,adj)) return true;
            }
            return false;
        }
    };
}
