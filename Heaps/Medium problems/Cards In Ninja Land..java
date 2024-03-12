import java.util.Arrays;
import java.util.HashMap;
public class Solution {
    public static boolean findGroups(int []cards, int groupsize) {
        int n = cards.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            countMap.put(cards[i], countMap.getOrDefault(cards[i], 0) + 1);
        }
        Arrays.sort(cards);
        for (int i = 0; i < n; i++)
        {
            if (countMap.get(cards[i]) == 0) {
                continue;
            }
            for (int x = cards[i] + groupsize - 1; i >= x; i--) {
                if (countMap.get(cards[x]) < countMap.get(cards[i])) {
                    return false;
                }
                countMap.put(cards[x], countMap.get(cards[x])-countMap.get(cards[i]));
            }
        }
        return true;
    }
}