import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class DisjointSetUnion{
    int start , end , visited , parent;

    DisjointSetUnion(int node){
        start = node;
        end = node;
        visited = 0;
        parent = node;
    }

}
public class Solution {

    public static class DisjointIntervals {

        DisjointSetUnion[] intervals = new DisjointSetUnion[10001];

        DisjointIntervals(){
            for (int i = 0 ; i < 10001 ; i++){
                intervals[i] = new DisjointSetUnion(i);
            }
        }
        public int find(int x){
            if (x == intervals[x].parent){
                return x;
            }
            return intervals[x].parent = find(intervals[x].parent);
        }

        public void unite(int x , int y){
            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY){
                intervals[parentY].parent  = parentX ;
                intervals[parentX].start =  Math.min (intervals[parentX].start  ,  intervals[parentY].start) ;
                intervals[parentX].end  =   Math.max (intervals[parentX].end , intervals[parentY].end) ;
                intervals[parentY].start =  Math.min (intervals[parentY].start  ,  intervals[parentX].start) ;
                intervals[parentY].end  =   Math.max (intervals[parentY].end , intervals[parentX].end) ;
            }

            return ;
        }

        public void addInteger(int val) {
            if (intervals[val].visited == 1){
                return ;
            }
            if (val - 1 >= 0 && intervals[val - 1].visited == 1){
                unite(val , val - 1);
            }
            if (intervals[val + 1].visited == 1){
                unite(val , val + 1);
            }
            intervals[val].visited = 1;
        }

        public List<List<Integer>> getDisjointIntervals() {
            List<List<Integer>> result = new  ArrayList<>();
            for (int i = 0 ; i < 10001 ; i++){
                if (intervals[i].parent == i && intervals[i].visited == 1){
                    result.add(new ArrayList<>(Arrays.asList(intervals[i].start , intervals[i].end)));
                }
            }

            return result;
        }
    }
}