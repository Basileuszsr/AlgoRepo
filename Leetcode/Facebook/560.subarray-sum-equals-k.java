import java.util.HashMap;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum= new HashMap<>();
        preSum.put(0, 1);
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

