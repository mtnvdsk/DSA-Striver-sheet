import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class Solution {
    static class Stack {
        // Define the data members.
        Queue<Integer> stac;

        public Stack() {
            this.stac = new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return stac.size();
        }

        public boolean isEmpty() {
            return stac.isEmpty();
        }

        public void push(int element) {
            stac.add(element);
            for(int i=0;i<stac.size()-1;i++)
            stac.add(stac.remove());
        }

        public int pop() {
           return stac.size()==0?-1:stac.remove();
        }

        public int top() {
            if (!stac.isEmpty()) {
                return stac.peek();
            } 
            return -1;
        }
    }
}
