/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        return (int) ((maxHeight * maxWidth) % mod);
    }
}
// @lc code=end

