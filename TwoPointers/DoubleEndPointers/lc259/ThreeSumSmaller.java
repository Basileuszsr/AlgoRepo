public class ThreeSumSmaller {
    public int threeSumSmaller(int[] arr, int target) {
        int count = 0;
        if (arr == null || arr.length < 3) return count;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
