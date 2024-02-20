import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isprime(int num){
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List< Integer > countPrimes(int n) {
        List<Integer> a=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0 && isprime(i)){
                a.add(i);
            }
        }
        return a;
    }
}