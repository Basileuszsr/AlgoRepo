/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            } 
            if (ch == 'R') {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
            } 
            if (ch == 'G') {
                switch (dir) {
                    case 0 : y++; break;
                    case 1 : x++; break;
                    case 2 : y--; break;
                    case 3 : x--; break;
                }
            }
        }
        if ((x == 0 && y == 0) || dir != 0) return true;
        return false;
    }
}
// @lc code=end

