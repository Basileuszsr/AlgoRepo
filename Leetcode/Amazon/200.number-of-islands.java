/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) return;
        if (grid[m][n] != '1') return;
        grid[m][n] = '#';
        dfs(grid, m + 1, n);
        dfs(grid, m - 1, n);
        dfs(grid, m, n + 1);
        dfs(grid, m, n - 1);
    }
}
// @lc code=end

