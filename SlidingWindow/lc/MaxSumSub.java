public class MaxSumSub {
    public int maxSumSub(int[] nums, int k) {
        int start = 0;
        int maxSum = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (end - start + 1 >= k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }
}
