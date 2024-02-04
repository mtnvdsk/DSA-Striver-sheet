public class Solution {
    public static int[] moveZeros(int n, int []a) {
    int i=0;
    for(int j=0;j<n;j++){
        if(a[j]!=0){
            int temp=a[j];
            a[j]=a[i];
            a[i]=temp;
            i++;
        }
    }
    return a;
}
}