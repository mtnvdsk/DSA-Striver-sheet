class Node {
    Node[] children;
    boolean isEnd;
	int count;

    Node() {
        this.isEnd = false;
        this.children = new Node[26];
		this.count=0;
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
				temp.count++;
            }
            temp = temp.get(word.charAt(i));
        }
        temp.setEnd();
    }

    public static int longestcp(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.containsKey(word.charAt(i))) {
				if(temp.count>1|| temp.getEnd()) return i;
                temp = temp.get(word.charAt(i));
			}
        }
        return word.length();
    }
}

public class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        String cm = "";
        Trie root = new Trie();

        for (int i = 0; i < n; i++) {
            root.insert(arr[i]);
        }

        int len=root.longestcp(arr[0]);
		return arr[0].substring(0,len);
        
    }
}
