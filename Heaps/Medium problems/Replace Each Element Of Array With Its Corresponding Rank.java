import java.util.*;


public class Solution {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();


        for(int i=0;i<n;i++){
            pq.add(arr.get(i));
        }
        int k = 1;
        while(!pq.isEmpty()){
            int top = pq.peek();
            if(!map.containsKey(top)){
                map.put(pq.poll(),k);
                k++;
            }else{
                pq.poll();
            }
            
        }
        for(int i=0;i<n;i++){
            ans.add(map.get(arr.get(i)));
        }
        return ans;


    }
}