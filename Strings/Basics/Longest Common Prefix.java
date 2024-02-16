public class Solution {
    public static String commonPrefix(String []arr,int n){
        StringBuilder a=new StringBuilder();
        String b=arr[0];
        for(int i=0;i<b.length();i++){
            char d=b.charAt(i);
            for(int j=1;j<arr.length;j++){
                if(arr[j].length()-1>=i && arr[j].charAt(i)== d){
                    continue;
                }
                else{
                    return a.toString().isEmpty()?"-1":a.toString();
                }
            }
            a.append(d);
        }
        return a.toString().isEmpty()?"-1":a.toString();
    }
}