public class Solution{
    static int st[],pos;
    static class Stack {
        Stack(int capacity) {
            // Write your code here.
            st=new int[capacity];
            pos=-1;
        }
        public void push(int num) {
            // Write your code here.
            if(pos<st.length-1){
              pos++;
              st[pos]=num;
            }
        }
        public int pop() {
            // Write your code here.
            int ele=-1;
            if(pos>=0){
              ele=st[pos];
              pos--;
            }
            return ele;
        }
        public int top() {
            // Write your code here.
            return pos>=0?st[pos]:-1;
        }
        public int isEmpty() {
            // Write your code here.
            return pos==-1?1:0;
        }
        public int isFull() {
            // Write your code here.
            return pos==st.length-1?1:0;
        }
    }
}
