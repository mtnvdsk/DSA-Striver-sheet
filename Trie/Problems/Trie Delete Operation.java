import java.util.* ;
import java.io.*; 
/********************************************************

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
};

*********************************************************/
public class Solution {

    public static boolean toDelete(TrieNode[] temp) {
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (temp[i] != null) {
                c++;
            }
        }
        return c <= 1;
    }

    public static TrieNode deleteWord(TrieNode root, String word) {
        int n = word.length();
        TrieNode temp = root;
        TrieNode[] parentStack = new TrieNode[n];

        // Traverse the Trie to find the node corresponding to the last character of the word
        for (int i = 0; i < n; i++) {
            parentStack[i] = temp;
            if (temp.children[word.charAt(i) - 'a'] != null) {
                temp = temp.children[word.charAt(i) - 'a'];
            } else {
                // The word does not exist in the Trie
                return root;
            }
        }

        // Delete the word by updating the Trie structure
        if (temp.isEnd) {
            temp.isEnd = false;
            for (int i = n - 1; i >= 0; i--) {
                if (toDelete(temp.children)) {
                    parentStack[i].children[word.charAt(i) - 'a'] = null;
                    temp = parentStack[i];
                } else {
                    break;
                }
            }
        }

        return root;
    }
}
