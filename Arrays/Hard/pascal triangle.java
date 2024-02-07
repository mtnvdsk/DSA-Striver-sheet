import java.util.*;
public class Solution {
    public static int[][] pascalTriangle(int N) {
        int[][] b=new int[N][];
        int[] c={1};
        int i;
        for(i=1;i<N;i++){
            b[i-1]=c;
            c=new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==i ||j==0) c[j]=1;
                else c[j]=b[i-1][j-1]+b[i-1][j];
            }
        }
        b[i-1]=c;
        return b;
    }
}