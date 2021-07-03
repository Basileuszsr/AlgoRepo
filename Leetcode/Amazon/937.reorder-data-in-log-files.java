/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);
            boolean aIsDigit = Character.isDigit(aSplit[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bSplit[1].charAt(0));
            if (aIsDigit && bIsDigit) {
                return 0;
            } else if (!aIsDigit && !bIsDigit) {
                int comp = aSplit[1].compareTo(bSplit[1]);
                if (comp == 0) {
                    return aSplit[0].compareTo(bSplit[0]);
                } else {
                    return comp;
                }
            } else if (aIsDigit) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}
// @lc code=end

