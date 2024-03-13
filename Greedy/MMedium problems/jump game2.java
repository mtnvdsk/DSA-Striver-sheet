public class Solution {
    public static int minJumps(int []arr, int n) {
        if(n==1) return 0;
        int farthest=0,curr=0,jump=0;
        boolean f=false;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,i+arr[i]);
            if(i==curr){
                curr=farthest;
                jump++;
            }
            if(farthest>=n-1) f=true;
        }
        if(f==false) return -1;
        return jump;
    }
}