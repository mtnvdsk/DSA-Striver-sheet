import java.util.* ;
import java.io.*; 
public class Solution {
    public static void rec(ArrayList<String> a,int n,int l,int r,String s){
        if(s.length()==n*2){ a.add(s); return;}
        if(l<n) rec(a,n,l+1,r,s+"(");
        if(r<l) rec(a,n,l,r+1,s+")");
    }
    public static ArrayList<String> validParenthesis(int n){
        ArrayList<String> a=new ArrayList<>();
        rec(a,n,0,0,"");
        return a;
    } 
}