public class Solution {
    public static int traffic(int n, int m, int []vehicle) {
        int i=0,k=0;
        while(i<n){
            if(vehicle[i]==0)
                m--;
            if(m<=-1){
                if(vehicle[k]==0)
                    m++;
                k++;
            }
            i++;
        }
        return i-k;
    }
}