/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right) {
            // 猜论文篇数
            int mid = (left + right + 1) / 2;
            // 满足高引用的特点是：引用次数 >= 论文篇数
            // count 的含义是：大于等于 mid 的论文篇数
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }
            if (count >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end

