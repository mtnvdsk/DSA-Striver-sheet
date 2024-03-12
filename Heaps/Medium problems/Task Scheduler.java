import java.util.* ;
import java.io.*; 
public class Solution {
    public static int taskScheduler(String s, int n, int k) {
        Map<Character,Integer> hm=new HashMap<>();
        for(char c:s.toCharArray()) hm.put(c,hm.getOrDefault(c,0)+1);
        Queue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
        int ans=0;
        pq.addAll(hm.values());
        while(!pq.isEmpty()){
          int ct=0,arr[]=new int[k+1];
          for(int i=0;i<=k;i++){
            if(!pq.isEmpty()){
              arr[i]=pq.poll()-1;
              ct++;
            }
          }
          for(int i:arr) if(i>0) pq.add(i);
          ans+=pq.isEmpty()?ct:k+1;
        }
        return ans;
    }
}
