/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean continueComp = true;
            for (int k = 0; k < Math.min(word1.length(), word2.length()) && continueComp; k++) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    } else {
                        continueComp = false;
                    }
                }
            } 
            if (continueComp && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

