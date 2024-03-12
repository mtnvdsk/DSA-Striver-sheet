import java.util.Scanner;

import java.util.PriorityQueue;

public class solution {
    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> ropes=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            ropes.offer(arr[i]);
        }
        int sum=0;
        while(ropes.size()>1){
            int a=ropes.poll();
            a+=ropes.poll();
            sum+=a;
            ropes.offer(a);
        }
        return sum;
    }
}