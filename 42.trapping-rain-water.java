import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek] < height[i]) {
                int currIndex = stack.pop();
                while (!stack.isEmpty() && height[stack.peek] == height[currIndex]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[i], stackTop) - height[currIndex]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
// @lc code=end

