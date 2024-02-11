public class Solution {
    public static int count(int arr[], int n, int x) {
        int f=-1;
        int l=-1;

        int si=0,ei=n-1;
        
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==x){
                f=mid;
                ei=mid-1;
            }
            else if(arr[mid]<x){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        si=0;
        ei=n-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==x){
                l=mid;
                si=mid+1;
            }
            else if(arr[mid]<x){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        //System.out.println(l+" "+f);
        if(f!=-1)
        return l-f+1;
        else
        return 0;
    }
}