public class Solution {
    public static int find(int[][] points,int[][] task,int last,int day){
        if(day==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        if(task[day][last]!=-1) return task[day][last];
        int max=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int point=points[day][i]+find(points,task,i,day-1);
                max=Math.max(max,point);
            }
        }
        return task[day][last]=max;
    }
    public static int ninjaTraining(int n, int points[][]) {
    //   int[][] dp=new int[n][4];
    //   for(int i=0;i<n;i++){
    //       for(int j=0;j<=3;j++){
    //           dp[i][j]=-1;
    //       }
    //   }
    //   return find(points,dp,3,n-1);

    //tabulation
    //   dp[0][0]=Math.max(points[0][1],points[0][2]);
    //   dp[0][1]=Math.max(points[0][0],points[0][2]);
    //   dp[0][2]=Math.max(points[0][0],points[0][1]);
    //   dp[0][3]=Math.max(points[0][1],Math.max(points[0][0],points[0][2]));
    //   for(int day=1;day<n;day++){
    //     for(int task=0;task<4;task++){
    //         dp[day][task]=0;
    //         for(int t=0;t<3;t++){
    //             if(t!=task){
    //                 int point=points[day][t]+dp[day-1][t];
    //                 dp[day][task]=Math.max(dp[day][task],point);
    //             }
    //         }
    //     }
    //   }
    //   return dp[n-1][3];

      //space optimization
        int[] dp = new int[4];
        dp[0]= Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day=1; day<n; day++){
            int[] temp = new int[4];
            for(int last=0; last<4; last++){
                int maximumPoint = 0;
                for(int task=0; task<3; task++){
                    if(task!=last){
                        int point = points[day][task] + dp[task];
                        maximumPoint = Math.max(maximumPoint, point);
                    }
                }
                temp[last] = maximumPoint;
            }
            dp = temp;
        }
        return dp[3];
    }

}