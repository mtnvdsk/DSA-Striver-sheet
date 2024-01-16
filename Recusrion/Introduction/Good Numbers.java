import java.util.ArrayList;
import java.util.List;
public class Solution {
    
    public static boolean isgood(int n,int digit){{
        if(n%10==digit){
            return false;
        }
        int sum=n%10;
        n=n/10;
        while(n!=0){
            if(n%10==digit|| n%10<=sum){
                return false;
            }
            sum+=n%10;
            n=n/10;
        }
        return true;
    }
        
    }
    public static List< Integer > goodNumbers(int a, int b, int digit) {
        List<Integer> ans=new ArrayList<>();
        for(int i=a;i<=b;i++){
            if(isgood(i,digit)){
                ans.add(i);
            }
        }
        return ans;
    }
}