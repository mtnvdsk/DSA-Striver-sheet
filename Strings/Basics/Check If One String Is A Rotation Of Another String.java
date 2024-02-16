public class Solution {

    public static int isCyclicRotation(String p, String q)  {
        p = p+p;
        int i=0;
        int j=0;
        while(i<p.length()){
            if(p.charAt(i) == q.charAt(j)){
                i++;
                j++;
                if(j==q.length()){
                    return 1;
                }
            }else if(q.charAt(j)!=p.charAt(i) && j!=0){
                j=0;
            }else{
                  i++;
            }
        }
        return 0;
    }
}

