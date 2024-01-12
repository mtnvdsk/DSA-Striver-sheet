import java.util.*;
class pair{
	int i,j;
	pair(int i,int j){
		this.i=i;
		this.j=j;
	}
}

public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		List<List<pair>> adj=new ArrayList<>();
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.size();i++){
			adj.get(edges.get(i).get(0)).add(new pair(edges.get(i).get(1),edges.get(i).get(2)));
			adj.get(edges.get(i).get(1)).add(new pair(edges.get(i).get(0),edges.get(i).get(2)));
		}
		int []vis=new int[n];
		Queue<pair> q=new PriorityQueue<>((x,y)->x.j-y.j);
		q.add(new pair(0,0));
		int sum=0;
		while(!q.isEmpty()){
			int wt=q.peek().j;
			int node=q.peek().i;
			q.remove();
			if(vis[node]==1) continue;
			vis[node]=1;
			sum+=wt;
			for(pair k:adj.get(node)){
				int awt=k.j;
				int anode=k.i;
				if(vis[anode]==0)
					q.add(new pair(anode,awt));
			}
		}
		return sum;
	}
}