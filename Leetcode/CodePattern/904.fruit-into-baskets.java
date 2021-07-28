/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int windowStart = 0, maxLength = 0;
        Map<Integer, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            fruitFrequencyMap.put(fruits[windowEnd], fruitFrequencyMap.getOrDefault(fruits[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(fruits[windowStart], fruitFrequencyMap.get(fruits[windowStart]) - 1);
                if (fruitFrequencyMap.get(fruits[windowStart]) == 0) {
                    fruitFrequencyMap.remove(fruits[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
// @lc code=end

