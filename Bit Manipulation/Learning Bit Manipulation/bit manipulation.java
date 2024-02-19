public class Solution {
    public static int[] bitManipulation(int num, int i){
        // Write your code here.
        int temp=num;
         i=i-1;
        int setvalue= (1<<i)&temp;;
        
        if(setvalue==0){
            temp=temp|(1<<i);
        }
        else{
            int mask=~(1<<i);
            num=num&mask;
        }
        int ans[]=new int [3];
        ans[0]=setvalue!=0?1:0;
        ans[1]=temp;
        ans[2]=num;

        return ans;
        
    }
}