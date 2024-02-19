public class Solution {
    public static int setBits(int N) {
        StringBuilder binaryRepresentation = new StringBuilder(Integer.toBinaryString(N));
        for (int i = binaryRepresentation.length() - 1; i >= 0; i--) {
            if (binaryRepresentation.charAt(i) == '0') {
                binaryRepresentation.setCharAt(i, '1');
                break;
            }
        }
        return Integer.parseInt(binaryRepresentation.toString(), 2);
    }
}