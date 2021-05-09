public class DutchFlag {
    public void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, i, left);
                left++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, right);
                right--;
            }
        }
    }

    private void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
