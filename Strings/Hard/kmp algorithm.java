import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List< Integer > stringMatch(String text, String pattern) {
        int n=text.length();
        List<Integer> a=new ArrayList<>();
        int m=pattern.length();
        int i=0,j=0;
        int []l=new int[m];
        cl(pattern,m,l);
        while(i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                if(j==m){
                a.add(i-j+1);
                j=l[j-1];                
                }
            }
            else {
                if(j!=0){
                j=l[j-1];}
                else{
                i++;}
            }
        }
        return a;
    }
    public static void cl(String pattern,int m,int[] l){
        int i=1;
        l[0]=0;
        int len=0;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                l[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=l[len-1];
                }
                else{
                    l[i]=len;
                    i++;
                }
            }
        }
    }
}