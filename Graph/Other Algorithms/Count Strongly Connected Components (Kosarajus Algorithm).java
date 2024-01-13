import java.util.*;

public class Solution {
	public static void dfs(int i,int []vis,Stack<Integer> st,List<List<Integer>> adj){
		vis[i]=1;
		for(int j:adj.get(i)){
			if(vis[j]==0) dfs(j,vis,st,adj);
		}
		st.push(i);
	}
	public static void dfs2(int i,int []vis,List<List<Integer>> adj){
		vis[i]=1;
		for(int j:adj.get(i)){
			if(vis[j]==0) dfs2(j,vis,adj);
		}
	}
	public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
		int[] vis=new int[v];
		List<List<Integer>> adj=new ArrayList<>();
		Stack<Integer> stac=new Stack<>();
		for(int i=0;i<v;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
		}
		for(int i=0;i<v;i++){
			if(vis[i]==0){
				dfs(i,vis,stac,adj);
			}
		}

		List<List<Integer>> adjt=new ArrayList<>();
		for(int i=0;i<v;i++){
			adjt.add(new ArrayList<>());
		}
		for(int i=0;i<v;i++){
			vis[i]=0;
			for(int j:adj.get(i)){
				adjt.get(j).add(i);
			}
		}

		int scc=0;
		while(!stac.isEmpty()){
			int node=stac.pop();
			if(vis[node]==0){
				scc++;
				dfs2(node,vis,adjt);
			}
		}
		return scc;
	}
}