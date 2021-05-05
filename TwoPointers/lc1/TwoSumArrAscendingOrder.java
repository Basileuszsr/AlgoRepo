package TwoPointers.lc1;

class TwoSumArrAscendingOrder {
    public static int[] search(int[] arr, int targetSum) {
      if (arr == null || arr.length <= 1) {
        return new int[] { -1, -1 };
      }
      int i = 0, j = arr.length - 1;
      while (i < arr.length && j >= 0) {
        if (arr[i] + arr[j] == targetSum) {
          return new int[] { i, j };
        } else if (arr[i] + arr[j] < targetSum) {
          i++;
        } else {
          j--;
        }
      }
      return new int[] { -1, -1 };
    }
  }
