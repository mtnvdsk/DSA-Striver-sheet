
public class Solution {
    public static void bub(int[] arr,int n){
        if(n==1)return;
        for(int j=0;j<=n-2;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
        }
        }
        bub(arr,n-1);
    }
    public static void bubbleSort(int[] arr, int n) {
        bub(arr,n);
        }
    }