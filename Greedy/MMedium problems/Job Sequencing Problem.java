import java.util.*;
public class Solution {
    public static int[] jobScheduling(int [][]jobs) {
        Arrays.sort(jobs,(a,b)->(b[2]-a[2]));
        int max=0;
        for(int i=0;i<jobs.length;i++){
            max=Math.max(max,jobs[i][1]);
        }
        int []seq=new int[max];
        int profit=0,currjobs=0;
        for(int i=0;i<max;i++)
            seq[i]=-1;
        for(int i=0;i<jobs.length;i++){
            for(int j=jobs[i][1]-1;j>=0;j--){
                if(seq[j]==-1){
                    seq[j]=jobs[i][1];
                    currjobs++;
                    profit+=jobs[i][2];
                    System.out.println(seq[j]+" "+profit);
                    break;
                }
            }
        }
        return new int[]{currjobs,profit};
    }
}
