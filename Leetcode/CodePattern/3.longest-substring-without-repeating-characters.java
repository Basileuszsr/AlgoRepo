/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int winStart = 0;
        int maxLen = 0;
        for (int winEnd = 0; winEnd < s.length(); winEnd++) {
            while (map.containsKey(s.charAt(winEnd))) {
                map.remove(s.charAt(winStart));
                winStart++;
            }
            map.put(s.charAt(winEnd), winEnd);
            maxLen = Math.max(winEnd - winStart + 1, maxLen);
        }
        return maxLen;
    }
}
// @lc code=end

