public class Solution {
    public static boolean jump_search(int []jump, int n){
        int j=0;
        for(int i=0;i<n;i++){
            if(i>j) return false;
            if(j>=n) return true;
            j=Math.max(j,i+jump[i]) ;
        }
        return true;
    }
}