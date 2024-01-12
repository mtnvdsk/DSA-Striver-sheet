import java.util.PriorityQueue;
import java.util.Queue;

class pair{
    int i,j;
    pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        int []ans=new int[1000];
        for(int i=0;i<1000;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        Queue<pair> q=new PriorityQueue<>((x,y)->x.j-y.j);

        q.add(new pair(start,0));
        int mod=(int)1000;
        ans[start]=0;
        while(!q.isEmpty()){
            int node=q.peek().i;
            int dist=q.peek().j;
            q.remove();
            for(int i=0;i<n;i++){
                int newnode=(node*a[i])%mod;
                if(dist+1<ans[newnode]){
                    ans[newnode]=dist+1;
                    if(!q.contains(new pair(newnode,ans[newnode])))
                        q.add(new pair(newnode,ans[newnode]));
                }
                if(newnode==end){
                    return ans[newnode];
                }
            }
        }
        return -1;
    }
}