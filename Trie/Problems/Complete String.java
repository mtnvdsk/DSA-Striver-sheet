class Node {
    Node[] children;
    boolean isEnd;

    Node() {
        this.isEnd = false;
        this.children = new Node[26];
    }

    boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }

    Node get(char c) {
        return children[c - 'a'];
    }

    void put(char c, Node node) {
        children[c - 'a'] = node;
    }

    void setEnd() {
        isEnd = true;
    }

    boolean getEnd() {
        return isEnd;
    }
}

class Trie {
    static Node root;

    Trie() {
        root = new Node();
    }

    public static void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }
        temp.setEnd();
    }

    public static boolean longestcp(String word) {
        Node temp = root;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (temp.containsKey(word.charAt(i))) {
                temp = temp.get(word.charAt(i));
                flag = flag && temp.getEnd();
            } else {
                return false;
            }
        }
        return flag;
    }
}

public class Solution {
    public static String completeString(int n, String[] arr) {
        String cm = "";
        Trie root = new Trie();

        for (int i = 0; i < n; i++) {
            root.insert(arr[i]);
        }

        String ans = "";
        for (int i = 0; i < n; i++) {
            if (root.longestcp(arr[i])) {
                if (arr[i].length() > ans.length()) {
                    ans = arr[i];
                } else if (arr[i].length() == ans.length() && arr[i].compareTo(ans) < 0) {
                    ans = arr[i];
                }
            }
        }
        if (ans.isEmpty()) {
            return "None";
        }
        return ans;
    }
}
