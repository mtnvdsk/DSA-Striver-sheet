import java.util.* ; 
import java.io.*;  
public class Solution {    

public static int ceilingInSortedArray(int n, int x, int[] arr) {  
    int a=lb(n,x,arr);       
    int b=ub(n,x,arr);       
    System.out.print(a+" ");    
    return b;                  
  } 
 static int lb(int n,int x,int []a){   
    int l=0,e=n-1,ans=-1;    
    while(l<=e){         
        int mid=(l+e)/2;         
        if(a[mid]<=x){           
        ans=a[mid];           
        l=mid+1;}         
        else  e=mid-1;        
    }     
   return ans;      
  }  
static int ub(int n,int x,int []a){
       int l=0,e=n-1,ns=-1;
       while(l<=e){
           int mid=(l+e)/2;
           if(a[mid]>=x){               
            ns=a[mid];              
            e=mid-1; }        
        else l=mid+1;
           }
       return ns;
       }
    }