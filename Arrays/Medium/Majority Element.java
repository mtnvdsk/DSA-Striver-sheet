import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int majorityElement(int []v) {
        int m=v.length/2;
        HashMap<Integer,Integer> a=new HashMap<>();
        int c=0;
        int e=0;
        for(int i=0;i<v.length;i++){
            if(a.containsKey(v[i]))
                a.put(v[i],a.get(v[i])+1);
            else
                a.put(v[i],1);
        }
        for(Map.Entry<Integer,Integer> b:a.entrySet()){
            int k=(int)b.getKey();
            int va=(int)b.getValue();
            if(va>m)
            return k;
        }
        return e;
    }
}