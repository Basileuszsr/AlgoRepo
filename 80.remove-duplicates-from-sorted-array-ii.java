/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int nextDup = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[nextDup - 2] != nums[i]) {
                nums[nextDup] = nums[i];
                nextDup++;
            }
        }
        return nextDup;
    }
}
// @lc code=end

