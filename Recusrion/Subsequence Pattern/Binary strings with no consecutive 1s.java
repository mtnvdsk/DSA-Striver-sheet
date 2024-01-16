import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void rec(List<String> l,String s,int n){
      if(s.length()>n) return;
      if(s.length()==n) l.add(s);
      rec(l,s+'0',n);
      if(s.length()==0 || s.charAt(s.length()-1)!='1') rec(l,s+'1',n);
      
    }
    public static List< String > generateString(int N) {
        List<String> a=new ArrayList<>();
        rec(a,"",N);
        return a;
    }
}
