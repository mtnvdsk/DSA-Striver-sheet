import java.util.*;

class HelloWorld {
    public static boolean possible(int[] a, int sum, List<List<Integer>> ans) {
        List<Integer> temp = new ArrayList<>();
        return rec(a, 0, sum, ans, temp);
    }

    public static boolean rec(int[] a, int i, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (i == a.length)
            return false;
        if (temp.stream().mapToInt(Integer::intValue).sum() == sum) {
            ans.add(new ArrayList<>(temp));
            temp.clear();
            return true;
        }
        if (rec(a, i + 1, sum, ans, temp)) return true;
        temp.add(a[i]);
        if (rec(a, i + 1, sum, ans, temp)) return true;
        temp.remove(temp.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,5,3};
        int totalSum = Arrays.stream(a).sum();
        List<List<Integer>> ans = new ArrayList<>();
        if (totalSum % 2 == 0) {
            boolean[] dp = new boolean[totalSum / 2 + 1];
            dp[0] = true;
            for (int i = 0; i < a.length; i++) {
                for (int j = totalSum / 2; j >= a[i]; j--) {
                    if (dp[j - a[i]]) {
                        dp[j] = true;
                    }
                }
            }
            if (dp[totalSum / 2]) {
                possible(a, totalSum / 2, ans);
                System.out.println("Set 1:");
                for (int j = 0; j < ans.get(0).size(); j++) {
                    System.out.print(ans.get(0).get(j) + " ");
                }
                System.out.println();
                System.out.println("Set 2:");
                for (int j = 0; j < a.length; j++) {
                    if (!ans.get(0).contains(a[j])) {
                        System.out.print(a[j] + " ");
                    }
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
