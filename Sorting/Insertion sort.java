public class Solution {
    public static void insertionSort(int[] a, int size) {
        if(size<=1)
        return;
        insertionSort(a, size-1);
        int l=a[size-1];
        int j=size-2;
        while(j>=0 && a[j]>l){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=l;
    }
}