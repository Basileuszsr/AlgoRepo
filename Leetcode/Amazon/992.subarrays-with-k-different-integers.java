/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    private int count(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int winStart = 0;
        int res = 0;
        for (int winEnd = 0; winEnd < nums.length; winEnd++) {
            map.put(nums[winEnd], map.getOrDefault(nums[winEnd], 0) + 1);
            while (map.size() > k) {
                int num = nums[winStart];
                map.put(num, map.get(num) - 1);
                if (map.get(num).equals(0)) {
                    map.remove(num);
                }
                winStart++;
            }
            res += winEnd - winStart + 1;
        }
        return res;
    }
}
// @lc code=end

