import java.util.*;
public class Solution {
    public static void rec(List<String> a,String s,String d,int n){
        if(n==s.length()){
            a.add(d);
            return;
        }
        rec(a,s,d+s.charAt(n),n+1);
        rec(a,s,d,n+1);
    }
    public static List<String> generateSubsequences(String s) {
        List<String> a=new ArrayList<>();
        rec(a,s,"",0);
        return a;
    }
}