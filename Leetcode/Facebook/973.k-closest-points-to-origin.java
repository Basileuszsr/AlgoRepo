/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[] {points[i][0], points[i][1]});
        }
        for (int i = k; i < points.length; i++) {
            int temp = maxHeap.peek()[0] * maxHeap.peek()[0] + maxHeap.peek()[1] * maxHeap.peek()[1];
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < temp) {
                maxHeap.poll();
                maxHeap.add(new int[] {points[i][0], points[i][1]});
            }
        }
        result.addAll(maxHeap);
        return result.toArray(new int[k][]);
    }
}
// @lc code=end

