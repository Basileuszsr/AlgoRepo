/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sumAB = 0;
        int len = nums1.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++){
                sumAB  = nums1[i] + nums2[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }
        int sumCD = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sumCD = nums3[i] + nums4[j];
                if (map.containsKey(-sumCD)) {
                    res += map.get(-sumCD);
                }
            }
        }
        return res;
    }
}
// @lc code=end

