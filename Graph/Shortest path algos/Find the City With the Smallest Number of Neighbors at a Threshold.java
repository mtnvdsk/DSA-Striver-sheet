import java.util.* ;

public class Solution {
	public static int findTheCity(int n, ArrayList<ArrayList<Integer>> edges, int distanceThreshold) {
		int[][] dist=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		for(ArrayList<Integer> i:edges){
			dist[i.get(0)][i.get(1)]=i.get(2);
			dist[i.get(1)][i.get(0)]=i.get(2);
		}
		for(int i=0;i<n;i++) dist[i][i]=0;

		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
						continue;
					}
					dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
		int cntcity=n;
		int cityn=-1;
		for(int i=0;i<n;i++){
			int c=0;
			for(int j=0;j<n;j++){
				if(dist[i][j]<=distanceThreshold){
					c++;
				}
			}
			if(c<=cntcity){
				cntcity=c;
				cityn=i;
			}
		}
		return cityn;
	}
}