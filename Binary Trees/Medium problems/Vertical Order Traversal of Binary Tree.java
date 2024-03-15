import java.util.*;


class Tuple{
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
public class Solution {
    public static List<Integer> verticalOrderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Tuple> queue = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        
        queue.add(new Tuple(root, 0, 0));

        int minimumVertical = Integer.MAX_VALUE;
        int maximumVertical = Integer.MIN_VALUE;

        int maximumLevel = Integer.MIN_VALUE;

        while(!queue.isEmpty()){

            Tuple tempValue = queue.poll();
            int vertical = tempValue.vertical;
            int level = tempValue.level;

            minimumVertical = Math.min(minimumVertical, vertical);
            maximumVertical = Math.max(maximumVertical, vertical);

            maximumLevel = Math.max(maximumLevel, level);

            // check for vertical in map if not present then insert it
            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new ArrayList<>());
            }

            map.get(vertical).get(level).add(tempValue.node.data);

            if(tempValue.node.left!=null){
                queue.add(new Tuple(tempValue.node.left, vertical-1, level+1));
            }

            if(tempValue.node.right!=null){
                queue.add(new Tuple(tempValue.node.right, vertical+1, level+1));
            }
        }


        // result is already created at top

        for(int i=minimumVertical ; i<= maximumVertical ; i++){

            ArrayList<Integer> ans = new ArrayList<>();

            for(int j=0 ; j<=maximumLevel ; j++){

                if(map.get(i).get(j)!=null){
                    ArrayList<Integer> temp = map.get(i).get(j);
                    Collections.sort(temp);
                    ans.addAll(temp);
                }
            }
            result.addAll(ans);
        }

        return result;
        
    }

}
