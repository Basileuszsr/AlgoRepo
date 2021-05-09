package TwoPointers.lc16;

import java.util.*;

public class ThreeSumClosest {
  public static int search(int[] arr, int target) {
    if (arr == null || arr.length < 3) {
      throw new IllegalArgumentException();
    }
    // 双指针算法一般来说都要数组有序，所以先排序。
    Arrays.sort(arr);
    int n = arr.length;
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < n - 2; i++) {
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        int localDiff = target - arr[i] - arr[left] - arr[right];
        if (localDiff == 0) {
          return target; // target == arr[i] + arr[left] + arr[right]
        }
        // 遍历结束后三数之和与target绝对值差距最小的会被记录下来
        if (Math.abs(localDiff) < Math.abs(minDiff)
            || Math.abs(localDiff) == Math.abs(minDiff) && localDiff < minDiff) {
          minDiff = localDiff;    
        }
        // 因为差距大了所以需要三数之和更大
        if (localDiff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return target - minDiff;
  }
}
