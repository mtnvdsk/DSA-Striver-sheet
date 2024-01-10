import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    Queue<Integer> q = new LinkedList();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int ind[] = new int[n+1];
    for(int i=0; i<=n; i++){
      adj.add(new ArrayList());
    }
      for(int i = 0; i<edges.size(); i++){
          int x = edges.get(i).get(0);    
          int y = edges.get(i).get(1);
          adj.get(x).add(y);
          ind[y]++;
      }
      for(int i=1; i<=n; i++){
        if(ind[i] == 0) q.add(i);
      }
      while(!q.isEmpty()){
        int x = q.poll();
          for(int i : adj.get(x)){
          ind[i]--;
          if(ind[i] == 0) q.add(i);
        }
      }
      for(int i=1; i<=n; i++){
        if(ind[i] != 0) return true;
      }
      return false;
  }
}