public class Solution {
    public static int isSorted(int n, int []a) {
        for(int i=0;i<a.length-1;i++){
            if(a[i]<=a[i+1]){

            }
            else{
                return 0;
            }
        }
        return 1;
    }
}