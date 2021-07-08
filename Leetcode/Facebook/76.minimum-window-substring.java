/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int result = Integer.MAX_VALUE;
        int l = 0;
        int winStart = 0;
        int valid = 0;
        for (int winEnd = 0; winEnd < s.length(); winEnd++) {
            char ch = s.charAt(winEnd);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(map.get(ch))) {
                    valid++;
                }
            }
            while (map.size() == valid) {
                char cha = s.charAt(winStart);
                if (winEnd - winStart + 1 < result) {
                    l = winStart;
                    result = winEnd - winStart + 1;
                }   
                if (map.containsKey(cha)) {
                    if (map.get(cha).equals(window.get(cha))) {
                        valid--;
                    }
                    window.put(cha, window.getOrDefault(cha, 0) - 1);
                }
                winStart++; 
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(l, l + result);
    }
}
// @lc code=end

