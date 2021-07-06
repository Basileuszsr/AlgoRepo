class Solution {
    public int connectSticks(int[] sticks) {
        int minCost = 0;
        if (sticks.length <= 1) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int next = first + second;
            minCost += next;
            minHeap.offer(next);
        }
        return minCost;
    }
}