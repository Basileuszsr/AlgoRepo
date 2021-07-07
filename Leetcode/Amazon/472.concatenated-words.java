/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    class Tries {
        Tries[] children = new Tries[26];
        boolean isEnd = false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Tries root = new Tries();
        for (String word : words) {
            Tries curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Tries();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }
        for (String s : words) {
            if (check(s.toCharArray(), 0, root, 0)) {
                res.add(s);
            }
        }
        return res;
    }
    private boolean check(char[] words, int index, Tries root, int wordCount) {
        if (index == words.length) {
            return wordCount > 1;
        }
        Tries curr = root;
        while (index < words.length && curr.children[words[index] - 'a'] != null) {
            curr = curr.children[words[index] - 'a'];
            index++;
            if (curr.isEnd && check(words, index, root, wordCount + 1)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

