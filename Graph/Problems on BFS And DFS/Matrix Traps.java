import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public static int matrixTraps(int n,int m, int [][]Matrix) {
        boolean [][]vis = new boolean[n][m];
        Queue< int[] > q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if((i==0 || j==0 || i==n-1 || j==m-1) && Matrix[i][j] == 0)
                {
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int []dx = new int[]{1, -1, 0, 0};
        int []dy = new int[]{0, 0, 1, -1};
        while(q.size() > 0)
        {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for(int i = 0; i <= 3; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m)
                {
                    if(Matrix[nx][ny] == 0 && vis[nx][ny] == false)
                    {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == false && Matrix[i][j] == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
