import java.util.ArrayList;

public class Solution 
{
    public static boolean verify(ArrayList<Integer> a,int mid,int k){
        int s=0;
        int p=1;
        for(int i=0;i<a.size();i++){
            if(s+a.get(i)<=mid){
                s+=a.get(i);
            }
            else{
                p++;
                s=a.get(i);
            }
        }
        return p>k;
    }
    public static int bs(ArrayList<Integer> a,int k){
        int low=a.get(0);
        int high=0;
        for(int i=0;i<a.size();i++){
            high+=a.get(i);
            low=Math.max(low,a.get(i));
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(verify(a,mid,k)) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        return bs(boards,k);
    }
}