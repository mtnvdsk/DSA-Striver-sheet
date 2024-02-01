import java.util.*;
 
class Node {
    Node links[] = new Node[2]; 
    
    public Node() {
    }
    boolean containsKey(int ind) {
        return (links[ind] != null); 
    }
    Node get(int ind) {
        return links[ind]; 
    }
    void put(int ind, Node node) {
        links[ind] = node; 
    }
}
class Trie {
    private static Node root; 

    Trie() {
        root = new Node(); 
    }

    public static void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(!node.containsKey(bit)) {
                node.put(bit, new Node()); 
            }
            node = node.get(bit); 
        }
    }
    
    public int getMax(int num) {
        Node node = root; 
        int maxNum = 0; 
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit); 
            }
            else {
                node = node.get(bit); 
            }
        }
        return maxNum; 
    }
}
public class Solution {
    public static int maximumXor(int []arr) {
        int n=arr.length;
        Trie trie = new Trie(); 
        for(int i = 0;i<n;i++) {
            trie.insert(arr[i]); 
        }
        int maxi = 0; 
        for(int i = 0;i<n;i++) {
            maxi = Math.max(maxi, trie.getMax(arr[i])); 
        }
        return maxi; 
    }
}
