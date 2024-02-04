import java.util.*;
public class Solution {

    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r)
        return;
        int mid=(r+l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] a,int l,int mid,int r){
        ArrayList<Integer> t=new ArrayList<>();
        int i=l;
        int j=mid+1;
        while(i<=mid && j<=r){
            if(a[i]>a[j]){
                t.add(a[j]);
                j++;
            }
            else{
                t.add(a[i]);
                i++;
            }
        }
        while(i<=mid){
            t.add(a[i]);
            i++;
        }
        while(j<=r){
            t.add(a[j]);
            j++;
        }
        for(int k=l;k<=r;k++){
            a[k]=t.get(k-l);
        }
    }
}
