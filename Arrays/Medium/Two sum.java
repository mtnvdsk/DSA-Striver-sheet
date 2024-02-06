import java.util.HashSet;

public class Solution {
    public static String read(int n, int []book, int target){
        HashSet<Integer> a=new HashSet<>();
        for(int i=0;i<n;i++){
            int b=target-book[i];
            if(a.contains(b)){
                return "YES";
            }
            a.add(book[i]);
        }
        return "NO";
    }
}