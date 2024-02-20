import java.util.*;
public class Solution {
    public static int[] bits(int e){
        int[] a=new int[32];
        int i=0;
        while(e>0){
            a[i++]=e%2;
            e=e/2;
        }
        return a;
    }
    public static int flipBits(int A, int B){
        int[] a=bits(A);
        int[] b=bits(B);
        int c=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                c++;
            }
        }
        return c;
    }
}