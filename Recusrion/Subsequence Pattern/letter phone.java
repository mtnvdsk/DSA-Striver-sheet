import java.util.*;
public class Solution {
    public static void rec(List<String> c,HashMap<Character,String> b,String a,String t,int i){
    if(i==a.length())
    {c.add(t);
    return;
    }
    String s=b.get(a.charAt(i));
    for(int j=0;j<s.length();j++){
        rec(c,b,a,t+s.charAt(j),i+1);
    }

    }
    public static List<String> letterCombinations(String a) {
        HashMap<Character,String> b=new HashMap<>();
        List<String> c=new ArrayList<>();
        b.put('0',"0");
        b.put('1',"1");
        b.put('2',"abc");
        b.put('3',"def");
        b.put('4',"ghi");
        b.put('5',"jkl");
        b.put('6',"mno");
        b.put('7',"pqrs");
        b.put('8',"tuv");
        b.put('9',"wxyz");
        rec(c,b,a,"",0);
        return c;
    }
}
