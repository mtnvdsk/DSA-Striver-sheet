package Dynamic Programming.Dp on squares;

public class Maximum rectangle {
    
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int h[]=new int [m];
        Stack<Integer> a=new Stack<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                 h[j]++;   
                }
                else h[j]=0;
            }
            for(int k:h)
            System.out.println(k);
            max=Math.max(max,maxArea(h));
        }
        return max;
    }
    public static int maxArea(int[] h){
        int max=0;
        int n=h.length;
        Stack<Integer> a=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!a.isEmpty() && (i==n || h[a.peek()]>=h[i])){
                int num=h[a.peek()];
                a.pop();
                int w;
                if(a.isEmpty()) w=i;
                else w=i-a.peek()-1;
                max=Math.max(max,w*num);
            }
            a.push(i);
        }
        return max;
    }   
}