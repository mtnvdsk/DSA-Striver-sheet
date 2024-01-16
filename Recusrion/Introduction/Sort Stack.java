import java.util.* ;
public class Solution {
	public static void rec(Stack<Integer> s){
		if(s.size()==1){
			return ;
		}
		int temp=s.pop();
		rec(s);
		sort(s,temp);
	}
	public static void sort(Stack<Integer> s,int temp){
		if(s.isEmpty()|| s.peek()<temp){
			s.push(temp);
			return;
		}
		int top=s.pop();
		sort(s,temp);
		s.push(top);
	}
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		rec(s);
		return s;
	}
}
