import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {

        // Constructor
        Stack<Integer> stac;
        Stack<Integer> minStack;
        MinStack() {
            this.stac=new Stack<>();
            this.minStack = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            stac.add(num);
            if(minStack.isEmpty()|| num<=minStack.peek()){
                minStack.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stac.isEmpty()) return -1;
            int pop=stac.pop();
            if(pop==minStack.peek()) minStack.pop();
            return pop;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stac.isEmpty()) return -1;
            return stac.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stac.isEmpty()) return -1;
            return minStack.peek();
        }
    }
}