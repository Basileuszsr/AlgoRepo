/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        for( ; i < intervals.length; i++) {
            if (start > intervals[i][1]) {
                res.add(new int[] {intervals[i][0], intervals[i][1]});
            } else {
                break;
            }
        }
        while (i < intervals.length && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[] {start, end});
        while (i < intervals.length) {
            res.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

