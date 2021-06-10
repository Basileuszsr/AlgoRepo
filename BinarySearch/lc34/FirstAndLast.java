public class FirstAndLast {
    public int[] firstAndLast(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        result[0] = findMax(nums, target, false);
        if (result[0] != -1) {
            result[1] = findMax(nums, target, true);
        }
        return result;
    }

    private int findMax(int[] nums, int target, boolean isMax) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (!isMax) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("Yes!");
    }
}
