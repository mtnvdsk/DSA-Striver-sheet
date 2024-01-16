import java.util.Stack;

public class Solution {
	public static void insert(Stack<Integer> s,int a){
		if(s.isEmpty()){
			s.push(a);
		}
		else{
			int b=s.peek();
			s.pop();
			insert(s,a);
			s.push(b);
		}
	}
    public static void reverse(Stack<Integer> s){
		if(s.size()>0){
			int a=s.peek();
			s.pop();
			reverse(s);
			insert(s,a);
		}
	}
	public static void reverseStack(Stack<Integer> stack) {
		reverse(stack);
	}

}
