import java.util.*;
public class Solution {
	public static int minimumReschedules(int n, int[][] intervals) {
		Arrays.sort(intervals,(a,b)->a[1]-b[1]);
		int re=0;
		int a[]=intervals[0];
		for(int i=1;i<n;i++){
			if(a[1]>intervals[i][0]){
				re++;
			}
			else{
				a=intervals[i];
			}
		}
		return re;
	}
}