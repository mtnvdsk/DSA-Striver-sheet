public class Solution {
    public static void heapify(int[] arr,int i,int n){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<n &&arr[left]>arr[i]){
            largest=left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr,largest,n);
        }

    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        for(int i=(n-2)/2;i>=0;--i){
            heapify(arr,i,n);
        }
        return arr;
    }
}