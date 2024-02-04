import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        int a=arr[0];
        for(int i:arr){
            if(i>a)
            a=i;
        }
        return a;
    }
}