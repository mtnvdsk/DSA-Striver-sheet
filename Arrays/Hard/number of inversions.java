import java.util.ArrayList;
import java.util.*;
public class Solution {
    public static int merge(int[] a,int low,int high){
        int c=0;
        if(low>=high) return c;
        int mid=(low+high)/2;
        c+=merge(a,low,mid);
        c+=merge(a,mid+1,high);
        c+=merger(a,low,mid,high);
        return c;
    }
    public static int merger(int[] a,int low,int mid,int high){
        int left=low;
        List<Integer> arr=new ArrayList<>();
        int right=mid+1;
        int c=0;
        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                arr.add(a[left]);
                left++;
            }else{
                arr.add(a[right]);
                c+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
            arr.add(a[left]);
            left++;
        }
        while(right<=high){
            arr.add(a[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            a[i]=arr.get(i-low);
        }
        return c;
    }
    public static int numberOfInversions(int []a, int n) {
        return merge(a,0,a.length-1);
        // int c=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(i<j && j!=i && a[i]>a[j]){
        //             c++;
        //         }
        //     }
        // }
        // return c;
    }
}