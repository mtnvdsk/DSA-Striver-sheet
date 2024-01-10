import java.util.*;

public class Solution {
    public static List<Integer> toposort(List<List<Integer>> adj,int k){
        int []ind=new int[k];
        for(int i=0;i<k;i++){
            for(int j:adj.get(i)){
                ind[j]++;
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(ind[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int t=q.poll();
            ans.add(t);
            for(int j:adj.get(t)){
                ind[j]--;
                if(ind[j]==0){
                    q.add(j);
                }
            }
        }
        return ans;
    }
    public static String getAlienLanguage(String []dictionary, int k) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<dictionary.length-1;i++){
            String s1=dictionary[i];
            String s2=dictionary[i+1];
            int ma=Math.min(s1.length(),s2.length());
            for(int j=0;j<ma;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        List<Integer> ans=toposort(adj,k);
        String s="";
        for(int i:ans){
            s+=(char)(i+(int)('a'));
        }
        return s;
    }
}