import java.util.HashMap;

public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        int n=a.length;
        int max=0;
        int xr=0;
        HashMap<Integer,Integer> c=new HashMap<>();
        c.put(xr,1);
        for(int i=0;i<n;i++){
            xr=xr^a[i];
            int x=b^xr;
            if(c.containsKey(x)){
                
                max+=c.get(x);
            }
            if(c.containsKey(xr)){
                c.put(xr,c.get(xr)+1);
            }
            else{
                c.put(xr,1);
            }
            
        }
        return max;
    }
}