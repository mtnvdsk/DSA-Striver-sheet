public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if(rear<arr.length-1)
            arr[rear++]=e;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            int e=-1;
            if(front!=rear){
                e=arr[front++];
            }
            return e;
        }
    }
}