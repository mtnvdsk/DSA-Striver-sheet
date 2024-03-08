import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> a=new Stack<>();
		for(int i=0;i<n;i++){
			a.push(i);
		}
		while(a.size()>1){
			int b=a.pop();
			int c=a.pop();
			if(Runner.knows(b,c)) a.push(c);
			else a.push(b);
		}
		int ans=a.pop();
		for(int i=0;i<n;i++){
			if(i==ans) continue;
			if(Runner.knows(ans,i)) return -1;
		}
		
		for(int i=0;i<n;i++){
			if(i==ans) continue;
			if(!Runner.knows(i,ans)) return -1;
		}
		return ans;
    }
}