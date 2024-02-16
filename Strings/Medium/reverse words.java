public class Solution {
    public static String revWords(String s) {
        String a[]=s.trim().split("\\s+");
        StringBuilder b=new StringBuilder();
        for(int i=a.length-1;i>0;i--){
            b.append(a[i]);
            b.append(" ");
        }
        b.append(a[0]);
        return b.toString();
    }
}