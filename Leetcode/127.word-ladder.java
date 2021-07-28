/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int len = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                char[] tempArray = temp.toCharArray();
                for (int j = 0; j < len; j++) {
                    char curr = tempArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (curr == k) {
                            continue;
                        }
                        tempArray[j] = k;
                        String newString = String.valueOf(tempArray);
                        if (set.contains(newString)) {
                            if (newString.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newString)) {
                                visited.add(newString);
                                queue.add(newString);
                            }
                        }
                    }
                    tempArray[j] = curr;
                }
                
            }
            step++;
        }
        return 0;
    }
}
// @lc code=end

