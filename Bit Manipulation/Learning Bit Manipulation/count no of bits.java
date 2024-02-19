public class Solution{

    static int setbit(int m)
    {
        int c=0;
        for(int i=0;i<32;i++)
        {
            if((1&(m>>i))==1)
               c++;
        }
        return c;
    }

    public static int countSetBits(int n) {
        int c=0;
        for(int i=1;i<=n;i++)
        {
            int x=setbit(i);
            c=c+x;
        }
           return c;
    }
}