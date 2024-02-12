import com.sun.org.apache.bcel.internal.generic.INEG;

public class Solution {
    public static double median(int[] a, int[] b) {
    	int n=a.length;
        int m=b.length;
        if(n>m) return median(b, a);
        int k=n+m;
        int left=(n+m+1)/2;
        int l=0,h=n;
        while(l<=h){
            int mid1=(l+h)/2;
            int mid2=left-mid1;
            int l1=Integer.MAX_VALUE,l2=Integer.MAX_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n) r1=a[mid1];
            if(mid2<m) r2=b[mid2];
            if(mid1-1>=0) l1=a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];
            if(l1<=r2 && l2<=r1){
                if(k%2==1) return Math.max(l1,l2);
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else if(l1>r2) h=mid1-1;
            else l=mid1+1;
 
        }
        return 0;
    }
}