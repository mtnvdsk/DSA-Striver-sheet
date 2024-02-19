public class Solution
{
    public static int divideTwoInteger(int dividend, int divisor)
    {
        boolean isDividendNegative = false;
        if(dividend < 0)
        {
            dividend *= -1;
            isDividendNegative = true;
        }

        boolean isDivisorNegative = false;
        if(divisor < 0)
        {
            divisor *= -1;
            isDivisorNegative = true;
        }

        long b = divisor;
        long a = dividend;

        long quotient = 0;

        for(int i = 30; i >= 0; i--)
        {
            if((b<<i) <= a)
            {
                a -= (b<<i);
                quotient |= (1<<i);
            }
        }

        // Both are negative.
        if(isDividendNegative && isDivisorNegative)
        {
            return (int)quotient;
        }

        // Both are positive.
        if(!isDividendNegative && !isDivisorNegative)
        {
            return (int)quotient;
        }

        // One is negative and one is positive.
        return -1*(int)quotient;
    }
}