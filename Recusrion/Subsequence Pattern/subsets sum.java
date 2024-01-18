import java.util.*;

import java.io.*;

 

public class Solution {

    public static void sol(int num[], int index, int sum, ArrayList<Integer> res, int n) {

        if (index == n) {

            res.add(sum);

            return;

        }

        sol(num, index + 1, sum, res, n);

        sol(num, index + 1, sum + num[index], res, n);

    }

 

    public static ArrayList<Integer> subsetSum(int num[]) {

        ArrayList<Integer> res = new ArrayList<>();

        sol(num, 0, 0, res, num.length);

        Collections.sort(res);

        return res;

    }

}