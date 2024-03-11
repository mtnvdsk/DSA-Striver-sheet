public class Solution {
    public static int findMaxFruits(int []arr, int n) {
        int last_f=-1;
        int second_last_f=-1;
        int last_f_c=0;
        int max=0;
        int c_max=0;

        for(Integer i:arr){
            if(i==last_f || i==second_last_f){
                c_max++;
            }else{
                c_max=last_f_c+1;
            }
            if(i==last_f){
                last_f_c++;
            }else{
                last_f_c=1;
            }
            if(i!=last_f){
                second_last_f=last_f;
                last_f=i;
            }
            max=Math.max(c_max,max);
        }
        return max;
    }
}