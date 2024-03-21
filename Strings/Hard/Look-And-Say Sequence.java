public class Solution {
    public static String lookAndSaySequence(int n) {
        String  val="1";
        for(int i=0;i<n-1;i++){
            char ch=val.charAt(0);
            int count=1;
            StringBuilder s=new StringBuilder();
            for(int j=1;j<val.length();j++){
                if(val.charAt(j)!=ch){
                    s.append(count);
                    s.append(ch);
                    count=0;
                    ch=val.charAt(j);
                }
                count++;
            }
            s.append(count);
            s.append(ch);
            val=s.toString();
        }
    return val; 
    }
}