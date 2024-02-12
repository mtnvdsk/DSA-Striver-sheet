import java.util.ArrayList;
public class Solution
{   
    public static int bs(ArrayList<Integer> a){
        if (a.size() == 1)
            return a.get(0);
        int low=1,high=a.size()-2;
        if(!a.get(0).equals(a.get(1))) return a.get(0);
        if(!a.get(a.size()-2).equals(a.get(a.size()-1))) return a.get(a.size()-1);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(!a.get(mid).equals(a.get(mid+1)) && !a.get(mid).equals(a.get(mid-1)))
            return a.get(mid);
            if(mid%2!=0 && a.get(mid).equals(a.get(mid-1)) || mid%2==0 && a.get(mid).equals(a.get(mid+1)))
            low=mid+1;
            else
            high=mid-1;
        }
        return -1;
    }
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        return bs(arr);
    }
}