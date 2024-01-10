
import java.util.ArrayList;

public class Solution {
    static boolean dfs( ArrayList< ArrayList<Integer> > graph, int[] visited, int currentNode ) {
        visited[currentNode] = 1;

        for (int i = 0; i < graph.get(currentNode).size(); i++) {
            if ((visited[graph.get(currentNode).get(i)] == 0 && dfs(graph, visited, graph.get(currentNode).get(i)) == true) || 
            visited[graph.get(currentNode).get(i)] == 1) {   
                return true;
            }
        }

        visited[currentNode] = 2;
        return false;        
    }

    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        int[] visited = new int[n];
        ArrayList< ArrayList<Integer> > graph = new ArrayList< ArrayList<Integer> >(n);
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            graph.add( new ArrayList<Integer>() );
        }

        for (int i = 0; i < e; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
    
    
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 2 || !dfs(graph, visited, i)) {
                answer.add(i);
            }
        }
        return answer;
    }
}