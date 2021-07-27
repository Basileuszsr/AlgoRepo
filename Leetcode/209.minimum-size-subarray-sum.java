/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
// @lc code=end

