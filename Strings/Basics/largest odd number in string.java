class Solution {
    public String largestOddNumber(String num) {
        String res="";
        for(int i=num.length()-1;i>=0;i--)
        {
            int n=Integer.valueOf(num.charAt(i));// converting character to integer
           if(n%2!=0)
           {
               res=res+num.substring(0,i+1);
               break; // break the loop as soon as it finds the last integer as odd number.
           }

        }
        return res;
    }
}