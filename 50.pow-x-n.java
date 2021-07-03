/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? myOwnPow(x, N): 1.0 / myOwnPow(x, -N);
    }

    private double myOwnPow(double x, long N) {
        if (N == 0) return 1.0;
        double y = myOwnPow(x, N / 2);
        return N % 2 == 0? y * y : y * y * x;
    }
}
// @lc code=end

