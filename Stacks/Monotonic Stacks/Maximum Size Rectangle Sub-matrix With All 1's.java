import java.util.*;

public class Solution {
    public static int maximalAreaOfSubMatrixOfAll1(int[][] matrix,int n,int m) {
        int[] heights = new int[m];
		int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    heights[j] = ++heights[j];
                }
				else heights[j]=0;
            }
			maxArea = Math.max(maxArea, maxAre(heights));
        }       
        return maxArea;
    }

    public static int maxAre(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
		int n=heights.length;
        for(int i=0;i<=n;i++){
			while(!stack.isEmpty() && (i==n || heights[stack.peek()]>=heights[i])){
				int num=heights[stack.pop()];
				int w;
				if(stack.isEmpty()) w=i;
				else w=i-stack.peek()-1;
				maxArea=Math.max(maxArea,w*num);
			}
			stack.push(i);
		}
		return maxArea;
    }
}
