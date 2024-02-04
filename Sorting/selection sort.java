public class Solution {
    public static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int b=i;
            for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[b])
                b=j;
            
            }
            int temp=arr[b];
            arr[b]=arr[i];
            arr[i]=temp;
        }
    }
}