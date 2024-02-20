public class SubsequencesBitManipulation {
    static void printSubsequences(String str) {
        int n = str.length();
        int totalSubsequences = (int) Math.pow(2, n);
        for (int i = 1; i < totalSubsequences; i++) {
            StringBuilder subsequence = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsequence.append(str.charAt(j));
                }
            }
            System.out.println(subsequence);
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println("All subsequences of \"" + input + "\":");
        printSubsequences(input);
    }
}
