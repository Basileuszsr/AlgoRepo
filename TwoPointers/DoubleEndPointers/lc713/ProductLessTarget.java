public class ProductLessTarget {
    public List<List<Integer>> productLessTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= target && left <= arr.length - 1) {
                product /= nums[left];
                left++;
            }
            List<Integer> temp = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                temp.add(0, nums[i]);
                result.add(new ArrayList<>(temp));
            }
        }
        return result;
    }
}
