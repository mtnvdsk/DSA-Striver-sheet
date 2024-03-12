import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < kArrays.size(); i++) {
            for (int j = 0; j < kArrays.get(i).size(); j++) {
                minHeap.add(kArrays.get(i).get(j));
            }
        }
		ArrayList<Integer> b=new ArrayList<>();
        while(!minHeap.isEmpty()){
			b.add(minHeap.poll());
		}

        return b;
    }
}
