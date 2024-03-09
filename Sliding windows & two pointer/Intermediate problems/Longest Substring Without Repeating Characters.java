import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		int n=input.length();
		int l=0;
		HashMap<Character,Integer> a=new HashMap<>();
		int i=0,j=0;
		while(j<n){
			if(a.containsKey(input.charAt(j)))
				i=Math.max(a.get(input.charAt(j))+1,i);
			a.put(input.charAt(j),j);
			l=Math.max(l,j-i+1);
			j++;
		}
		return l;
	}
}