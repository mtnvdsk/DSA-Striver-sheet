import java.util.*;

class Disjoint {
    static int[] rank;
    static int[] parent;

    Disjoint(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize each element as its own parent
        }
    }

    public int findUPrnt(int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = findUPrnt(parent[u]);
    }

    public void unionByRank(int u, int v) {
        int up = findUPrnt(u);
        int vp = findUPrnt(v);
        if (rank[up] < rank[vp]) {
            parent[up] = vp;
        } else if (rank[vp] < rank[up]) {
            parent[vp] = up;
        } else {
            parent[vp] = up;
            rank[up] += 1;
        }
    }
}

public class Solution {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint dj = new Disjoint(n);
        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    dj.unionByRank(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedmail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedmail[i] = new ArrayList<String>();
        }

        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = dj.findUPrnt(entry.getValue());
            mergedmail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedmail[i].size() == 0) continue;
            Collections.sort(mergedmail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedmail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
