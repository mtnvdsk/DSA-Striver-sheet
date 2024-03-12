import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static ArrayList<Integer> kLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> a=new PriorityQueue<>();
		ArrayList<Integer> b=new ArrayList<>();
		for(int i=0;i<n;i++){
			a.add(input[i]);
			if(a.size()>k){
				a.poll();
			}
		}
		while(!a.isEmpty()){
			b.add(a.poll());
		}
		return b;
	}
}