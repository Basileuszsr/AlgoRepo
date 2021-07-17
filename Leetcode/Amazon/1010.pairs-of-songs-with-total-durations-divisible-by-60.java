package Amazon;
/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] counts = new int[60];
        int res = 0;
        for (int t : time) {
            counts[t % 60] += 1;
        }
        int i = 1;
        int j = 59;
        res += counts[0] * (counts[0] - 1) / 2;
        res += counts[30] * (counts[30] - 1) / 2;
        while (i < j) {
            res += counts[i++] * counts[j--];
        }
        return res;
    }
}
// @lc code=end

