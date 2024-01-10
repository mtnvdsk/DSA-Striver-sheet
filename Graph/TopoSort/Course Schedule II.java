import java.util.*;
public class Solution {
    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
     List<List<Integer>> l=new ArrayList<>();
     for(int i=0;i<numCourses;i++) 
        l.add(new ArrayList<>());
        
     for(int i=0;i<prerequisites.size();i++){
       int a=prerequisites.get(i).get(0);
       int b=prerequisites.get(i).get(1);
       l.get(b-1).add(a-1);
      }
      int indeg[]=new int[numCourses];
      List<Integer> ans=new ArrayList<>();
      Queue<Integer> q=new LinkedList<>();
      for(int i=0;i<l.size();i++) 
        for(int j:l.get(i)) 
            indeg[j]++;
        
      for(int i=0;i<indeg.length;i++) 
        if(indeg[i]==0) 
            q.add(i);

      while(!q.isEmpty()){
        int curr=q.poll();
        ans.add(curr+1);
        for(int i=0;i<l.get(curr).size();i++){
            indeg[i]--;
            if(indeg[i]==0) q.add(i);
        }
      }
      if(ans.size()==numCourses) return ans;
      return new ArrayList<>();
    }
}