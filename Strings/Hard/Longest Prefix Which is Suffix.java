public class Solution {
    public static String longestPrefixSuffix(String str){
        int n=str.length();
        int i=1;
        int[] l=new int[n];
        int len=0;
        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                l[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=l[len-1];
                }
                else{
                    i++;
                }
            }
        }
        for(int k:l)
        System.out.println(k);
        return l[n-1]==0?"":str.substring(0,l[n-1]);
    }
}