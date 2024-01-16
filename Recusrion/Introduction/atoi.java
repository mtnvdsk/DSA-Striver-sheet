public class Solution {

    public static int createAtoi(String str, int i, double num, int sign) {

        

        if(i >= str.length() || str.charAt(i) < '0' || str.charAt(i) > '9') {

            num *= sign;

            if(num > Integer.MAX_VALUE) {

                return Integer.MAX_VALUE;

            } else if(num < Integer.MIN_VALUE) {

                return Integer.MIN_VALUE;

            } else {

                return (int)num;

            }

        }

 

        num = num * 10 + (str.charAt(i) - '0');

        return createAtoi(str, i + 1, num, sign);

    }

 

    public static int createAtoi(String str) {

        str = str.trim();

        if(str.length() == 0) {

            return 0;

        }

 

        int sign = 1;

        int i = 0;

        if(str.charAt(0) == '-') {

            sign = -1;

            i++;

        } else if(str.charAt(0) == '+') {

            i++;

        }

 

        return createAtoi(str, i, 0, sign);

    }

}