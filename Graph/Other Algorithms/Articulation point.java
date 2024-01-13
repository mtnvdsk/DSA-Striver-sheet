import java.io.*;
import java.util.*;
public class Solution{
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,boolean []vis, boolean isArticulation[],
     int tin[], int low[], int timer){
         vis[node] = true;
         tin[node] = low[node] = timer++;
         int child = 0;
         for(int it: adj.get(node)){
             if(it == parent) continue;
             if(!vis[it]){
                dfs(it,node,adj,vis,isArticulation,tin,low,timer); 
                low[node] = Math.min(low[it], low[node]);
                if(low[it] >= tin[node] && parent!=-1){
                    isArticulation[node] = true;
                }
                child++;
             }
            else{
                low[node] = Math.min(tin[it], low[node]);
            }
         }
         if(child>1 && parent==-1){
             isArticulation[node] = true;
         }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            n++; //beacuse of one base indexing
            int e =sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean vis[] = new boolean[n];
            int tin[] = new int[n];
            int low[] = new int[n];
            boolean isArticulation[] = new boolean[n];
            int timer = 0;
            for(int i = 1; i<n; i++){
                if(!vis[i]){
                    dfs(i,-1,adj,vis,isArticulation,tin,low,timer);
                }
            }
            for(int i = 1; i<n; i++){
                if(isArticulation[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}