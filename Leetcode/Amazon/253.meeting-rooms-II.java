class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> (a[1] - b[1]));
        int minRooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
