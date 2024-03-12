import java.util.*;
public class Solution {

    class Twitter {
        List<Pair>ans;
        HashMap<Integer,HashMap<Integer,Integer>>hm;
        class Pair{
            int user;
            int tweetId;
            Pair(int user, int tweetId){
                this.user=user;
                this.tweetId=tweetId;
            }
        }

        Twitter() {
            ans=new ArrayList<>();        
            hm=new HashMap<>();
        }
        public void postTweet(int userId, int tweetId){
            ans.add(new Pair(userId,tweetId));        
        }
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feed=new ArrayList<>();
            int cnt = 0;
            for (int i=ans.size()-1;i>=0 && cnt<10;i--){
                if(ans.get(i).user==userId || 
                (hm.containsKey(userId) && hm.get(userId).containsKey(ans.get(i).user))){
                    feed.add(ans.get(i).tweetId);
                    cnt++;
                }
            }
            return feed;
        }
        public void follow(int followerId, int followeeId) {
            if(hm.containsKey(followerId)){
                hm.get(followerId).put(followeeId, 1);
            }else{
                hm.put(followerId,new HashMap<>());
                hm.get(followerId).put(followeeId, 1);
            }
        }
        public void unfollow(int followerId, int followeeId) {
            if (hm.containsKey(followerId) && hm.get(followerId).containsKey(followeeId)){
                hm.get(followerId).remove(followeeId);
            }
        }
    }
}