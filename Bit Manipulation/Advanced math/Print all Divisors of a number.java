import java.util.*;
public class Solution{
    public static List< Integer > printDivisors(int n) {
        List<Integer> a=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0){
                a.add(i);
            }
        }
        return a;
    }
}