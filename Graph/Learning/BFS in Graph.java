package Learning;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        Queue<Integer> a=new LinkedList<>();
        int []vis=new int[n];
        vis[0]=1;
        a.add(0);
        List<Integer> ans=new ArrayList<>();
        while(!a.isEmpty()){
            int t=a.poll();
            ans.add(t);
            for(int i:adj.get(t)){
                if(vis[i]==0){
                    vis[i]=1;
                    a.add(i);
                }               
            }
        }
        return ans;
    }
}

