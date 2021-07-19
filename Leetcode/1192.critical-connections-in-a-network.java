import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(connections, map);
        int[] id = new int[n];
        Arrays.fill(id, -1);
        dfs(0, 0, -1, id, connections, map, res);
        return res;
    }

    private int dfs(int node, int nodeID, int par, int[] id, List<List<Integer>> connections, HashMap<Integer, Set<Integer>> map, List<List<Integer>> res) {
        id[node] = nodeID;
        Set<Integer> set = map.get(node);
        for (Integer n : set) {
            if (n == par) {
                continue;
            }
            if (id[n] == -1) {
                id[node] = Math.min(id[node], dfs(n, nodeID + 1, node, id, connections, map, res));
            } else {
                id[node] = Math.min(id[node], id[n]);
            }
        }
        if (id[node] == nodeID && node != 0) {
            res.add(Arrays.asList(node, par));
        }
        return id[node];
    }
    private void buildMap(List<List<Integer>> con, HashMap<Integer, Set<Integer>> map) {
        for (List<Integer> list : con) {
            int n1 = list.get(0);
            int n2 = list.get(1);
            Set<Integer> n1n = map.getOrDefault(n1, new HashSet<Integer>());
            Set<Integer> n2n = map.getOrDefault(n2, new HashSet<Integer>());
            n1n.add(n2);
            n2n.add(n1);
            map.put(n1, n1n);
            map.put(n2, n2n);
        }
    }
}
// @lc code=end

