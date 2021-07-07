import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        int[] visited = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(adjList, visited, i);
            }
        }
        return res;
    }
    
    private void dfs(List<Integer>[] adjList, int[] visited, int start) {
        visited[start] = 1;
        for (int i = 0; i < adjList[start].size(); i++) {
            if (visited[adjList[start].get(i)] == 0) {
                dfs(adjList, visited, adjList[start].get(i));
            }
        }
    }
}
