import java.util.HashSet;
import java.util.*;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> a,int n) {
		int i=1;
		for(int j=1;j<n;j++){
			if(!a.get(i-1).equals(a.get(j))){
				a.set(i, a.get(j));
				i++;
				//System.out.println(a.get(i)+" "+a.get(j)+" "+i+" "+j);
			}
		}
		return i;
	}
}