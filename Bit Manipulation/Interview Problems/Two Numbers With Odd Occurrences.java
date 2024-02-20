public class Solution {

    public static int[] twoOddNum(int []arr){
        int n = arr.length;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num^=arr[i];
        }
        int rmbm = num & (-num); //rmbm -> right most bit mask
        int x = 0, y=0;
        for (int i : arr) {
            if((i&rmbm)==0){
                x^=i;
            }else{
                y^=i;
            }
        }
        return new int[]{Math.max(x, y),Math.min(x, y)};
    }
}