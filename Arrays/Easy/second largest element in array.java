public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        int b=a[0];
        int sb=-1;
        for(int i:a){
            if(i>b){
                sb=b;
                b=i;
            }
            else if(i>sb){
                sb=i;
            }
        }
        int c=Integer.MAX_VALUE;
        int sc=-1;
        for(int i:a){
            if(i<c){
                sc=c;
                c=i;
            }
            else if(i<sc){
                sc=i;
            }
        }
        return new int[]{sb,sc};
    }
}