import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public static int[] KMostFrequent(int n, int k, int[] arr) {

        if (k == n) {
			return arr;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int ele : arr) {

			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
		Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
		for (int key : map.keySet()) {

			heap.add(key);
		}

		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {

			ans[i] = heap.poll();
		}

		return ans;
	}

}
