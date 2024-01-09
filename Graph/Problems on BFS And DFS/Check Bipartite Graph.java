import java.util.ArrayList;

public class Solution {
    public static boolean dfs(int node, int color, int [] colors, ArrayList<ArrayList<Integer>> adj){
        colors[node] = color;
        for (int neighbour : adj.get(node)){
            if (colors[neighbour] == 0){
                if(!dfs(neighbour, -color, colors, adj)) return false;
            }
            if (colors[neighbour] == color) return false;
        }
        return true;
    }
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        // Write your code here
        int vertex = edges.size();
        int [] colors = new int[vertex];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertex; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < vertex; i++){
            for (int j = 0; j < edges.get(i).size(); j++){
                if(edges.get(i).get(j) == 1) adj.get(i).add(j);
            }
        }
        for (int i = 0; i < vertex; i++){
            if(colors[i] == 0 && !dfs(i, 1, colors, adj)) return false;
        }
        return true;
    }

}