import java.util.* ;
import java.io.*; 
class TrieNode{
    TrieNode[] links;
    int endsWith;
    int countPrefix;
    TrieNode(){
        this.links = new TrieNode[26];
        this.endsWith = 0;
        this.countPrefix=0;
    }
    boolean containsKey(char ch){
        return this.links[ch-'a']!=null;
    }
    void putLetter(char ch, TrieNode node){
        this.links[ch-'a'] = node;
    }
    void incrementStartsWith(){
        this.countPrefix+=1;
    }
    void decrementStartsWith(){
        this.countPrefix-=1;
    }
    void incrementEndsWith(){
        this.endsWith+=1;
    }
    void decrementEndsWith(){
        this.endsWith-=1;
    }
    int getEndsWith(){
        return this.endsWith;
    }
    int getStartsWith(){
        return this.countPrefix;
    }
    TrieNode getLink(char ch){
        return this.links[ch-'a'];
    }

}
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.putLetter(ch, new TrieNode());
            }
            node = node.getLink(ch);
            node.incrementStartsWith();
        }
        node.incrementEndsWith();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.getLink(ch);
        }
        return node.getEndsWith();
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.getLink(ch);
        }
        return node.getStartsWith();
    }

    public void erase(String word) {
        TrieNode node = root; 
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode next = node.getLink(ch);
            if(next.getStartsWith()==1){
                node.putLetter(ch, null);//deallocating the memory
                return;
            }
            node = next;
            node.decrementStartsWith();
        }
        node.decrementEndsWith();
    }

}