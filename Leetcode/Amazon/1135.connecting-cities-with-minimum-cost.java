import java.util.*;

class Solution {
    static class Union {
        Map<Integer, Integer> nodeParent;
        public Union(int n) {
            this.nodeParent = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                nodeParent.put(i, i);
            }
        }
        public int findParent(int n) {
            if (n == nodeParent.get(n)) {
                return n;
            }
            return findParent(nodeParent.get(n));
        }
        public void union(int a, int b) {
            int n1 = findParent(a);
            int n2 = findParent(b);
            if (n1 == n2) {
                return;
            }
            nodeParent.put(n2, n1);
        }
    }
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int edges = 0;
        int cost = 0;
        Union u = new Union(n);
        for (int i = 0; i < connections.length; i++) {
            int n1 = connections[i][0];
            int n2 = connections[i][1];
            int a1 = u.findParent(n1);
            int a2 = u.findParent(n2);
            if (a1 != a2) {
                cost += connections[i][2];
                edges++;
                u.union(n1, n2);
            }
            if (edges == n - 1) {
                break;
            }
        }
        if (edges == n - 1) {
            return cost;
        }
        return -1;
    }
}