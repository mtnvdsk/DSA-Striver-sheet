/*
Definition of TrieNode class.

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd;
    TrieNode()
    {
        this.isEnd = false;
        for(int i=0;i<26;i++)
            children[i] = null;
    }
}; */
public class Solution extends TrieNode{
    // Abstract method for insertion
    public void insert(String word){
        int n=word.length();
        TrieNode temp=this;
        for(int i=0;i<n;i++){
            if(temp.children[word.charAt(i)-'a']==null){
                temp.children[word.charAt(i)-'a']=new Solution();
            }
            temp=temp.children[word.charAt(i)-'a'];
        }
        temp.isEnd=true;
    }

    // Abstract method for searching
    public boolean search(String word){
        int n=word.length();
        TrieNode temp=this;
        for(int i=0;i<n;i++){
            if(temp.children[word.charAt(i)-'a']==null) return false;
            else{
                temp=temp.children[word.charAt(i)-'a'];
            }
        }
        return temp.isEnd;
    }

    // Abstract method for startsWith
    public boolean startsWith(String word){
        int n=word.length();
        TrieNode temp=this;
        for(int i=0;i<n;i++){
            if(temp.children[word.charAt(i)-'a']==null) return false;
            else{
                temp=temp.children[word.charAt(i)-'a'];
            }
        }
        return true;
    }
}