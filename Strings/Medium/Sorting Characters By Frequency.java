import java.util.*;

public class Solution {

    public static String sortByFrequency(int n, String s) {
        HashMap<Character,Integer> d=new HashMap<>();
        StringBuilder r = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(d.containsKey(ch)){
                int v=d.get(ch);
                d.put(ch,v+1);
            }
            else{
                d.put(ch,1);
            }
        }
        List<Character> l=new ArrayList<>(d.keySet());
        l.sort((a, b) -> d.get(b) - d.get(a));
        for(char c:l){
            int frequency = d.get(c);
            for (int i = 0; i < frequency; i++) {
                r.append(c);
            }
        }
        return r.toString();
    }
}