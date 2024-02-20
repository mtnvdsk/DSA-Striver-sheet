import java.util.Stack;

public class Solution{
    static class Queue {
        
        Stack<Integer> stac1;
        Stack<Integer> stac2;
        Queue() {
            // Initialize your data structure here.
            this.stac1=new Stack<>();
            this.stac2=new Stack<>();
        }

        void enQueue(int val) {
            while(stac1.isEmpty()==false){
                stac2.push(stac1.pop());
            }
            stac1.push(val);
            while(stac2.isEmpty()==false){
                stac1.push(stac2.pop());
            }
        }

        int deQueue() {
            if(stac1.isEmpty()) return -1;
            return stac1.pop();
        }

        int peek() {
            if(stac1.isEmpty()) return -1;
            return stac1.peek();
        }

        boolean isEmpty() {
            if(stac1.isEmpty()) return true;
            return false;
        }
    }
}