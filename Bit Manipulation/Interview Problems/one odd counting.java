public class Solution{
    public static int missingNumber(int n, int []arr){
        int k=0;
        for(int i:arr)
        k=k^i;
        return k;
    }
}