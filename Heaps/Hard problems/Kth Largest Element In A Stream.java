import java.util.PriorityQueue;

public class Solution {
    public static class Kthlargest {
        int k;
        PriorityQueue<Integer> nums;
        Kthlargest(int k, int []arr) {
            this.k=k;
            this.nums=new PriorityQueue<>(k);
            for(int i=0;i<arr.length;i++){
                this.nums.offer(arr[i]);
            }
        }

        int add(int num) {
            if(nums.size()<k) nums.offer(num);
            else if(nums.peek()<num){
                nums.poll();
                nums.offer(num);
            }
            return nums.peek();
        }
    }
}