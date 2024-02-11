import java.util.*;
public class Solution {
    public static int search(ArrayList<Integer> arr, int n, int k) {     
        int l=0,r=n-1,ans=-1;
        while(l<=r){
          int mid=(l+r)/2;
          if(arr.get(mid)==k) ans=mid;
          if(arr.get(l)<=arr.get(mid)){
            if(arr.get(l)<=k && k<=arr.get(mid)) r=mid-1;
            else l=mid+1;
          }
          else{
            if(arr.get(mid)<=k && k<=arr.get(r)) l=mid+1;
            else r=mid-1;
          }
        }
       return ans;
    }
}