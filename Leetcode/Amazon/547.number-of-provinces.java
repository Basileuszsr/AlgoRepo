package Amazon;
/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int curr, int[][] isConnected, boolean[] visited) {
        visited[curr] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[curr][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
// @lc code=end

