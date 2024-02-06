import java.util.*;

public class Solution {

    public static List< Integer > superiorElements(int []a) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=a.length;
        int max=a[n-1];
        ans.add(a[n-1]);
        for(int i=n-2;i>=0;i--){
            if(a[i]>max){
                ans.add(a[i]);
                max=a[i];
            }
        }
        return ans;
    }
}