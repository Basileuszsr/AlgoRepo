public class MinSizeSub {
    public int minSizeSub(int S, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= S) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
