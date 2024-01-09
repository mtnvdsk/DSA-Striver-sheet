import java.util.*;
class Pair{
  String word;
  int sequenceCount;
  Pair(String word,int sequenceCount){
      this.word=word;
      this.sequenceCount=sequenceCount;
   }
}
public class Solution {

  public static int wordLadder(String begin, String end, ArrayList <String> dict) {
      // Write your code here.
     
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(begin,1));
    Set<String> h=new HashSet<>();
    for(String s:dict) h.add(s);
    h.remove(begin);
    while(!q.isEmpty()){
      Pair curr=q.poll();
      if(curr.word.equals(end)) return curr.sequenceCount;
     for(int i=0;i<curr.word.length();i++){
      for(char ch='a';ch<='z';ch++){
        char chArr[]=curr.word.toCharArray();
        chArr[i]=ch;
        String newWord=new String(chArr);
        if(h.contains(newWord)){
          q.add(new Pair(newWord, curr.sequenceCount+1));
          h.remove(newWord);
       }
      }
     }
    }
    return -1;  
  }
}