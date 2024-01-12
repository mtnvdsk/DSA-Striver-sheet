import java.util.*;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public static int numberOfWays(int n, int m, int[][] roads) {
        final int mod = 1_000_000_007;
        int[][] adj = new int[n][n];
        for(int[] road : roads){
            adj[road[0]][road[1]] = road[2];
            adj[road[1]][road[0]] = road[2];
        }
        long[] cost = new long[n], ways = new long[n];
        Arrays.fill(cost,1,n, Long.MAX_VALUE);
        ways[0]=1;
        Queue<long[]> q = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
        q.offer(new long[]{0,0});
        while(!q.isEmpty()){
            long[] e = q.poll();
            int v = (int) e[0];
            long t = e[1];
            if(t <= cost[v]){
                for(int i=0;i<n;i++){
                    if(adj[v][i]!=0){
                        if(cost[v]+adj[v][i] < cost[i]){
                            cost[i] = cost[v]+adj[v][i];
                            q.offer(new long[]{i,cost[i]});
                            ways[i] = ways[v];
                        }
                        else if(cost[v]+adj[v][i] == cost[i]){
                            ways[i] = (ways[i]+ways[v]) % mod;
                        }
                    }
                }
            }
        }
        return (int) ways[n-1];
    }
}