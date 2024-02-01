
import java.util.ArrayList;
class Trie{
	Trie[] children;
	Trie(){
		this.children=new Trie[26];
	}
	Trie get(char c) {
        return children[c - 'a'];
    }
	boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }
    void put(char c, Trie node) {
        children[c - 'a'] = node;
    }
}
public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		Trie root=new Trie();
		
		int c=0;
		int n=s.length();
		for(int i=0;i<n;i++){
			Trie temp=root;
			for(int j=i;j<n;j++){
				if(!temp.containsKey(s.charAt(j))){
					c++;
					temp.put(s.charAt(j),new Trie());
				}
				temp=temp.get(s.charAt(j));
			}
		}
		return c+1;
	}
}