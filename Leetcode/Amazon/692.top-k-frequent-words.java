import java.util.*;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });
        for (String s : map.keySet()) {
           minHeap.offer(s);
           if (minHeap.size() > k) {
               minHeap.poll();
           }
        }
        while (minHeap.size() > 0) {
            res.add(0, minHeap.poll());
        }
        return res;
    }
}
// @lc code=end

