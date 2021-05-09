package TwoPointers.lc15;

import java.util.*;

public class ThreeSum {
  public static List<List<Integer>> search(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    //先排序
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      //因为按升序排所以只要有大于0的就一定不可能找到sum == 0的组合
      if (arr[i] > 0) {
        break;
      }
      //去除重复
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      int start = i + 1;
      int end = arr.length - 1;
      while (start < end) {
        int sum = arr[i] + arr[start] + arr[end];
        if (sum == 0) {
          triplets.add(Arrays.asList(arr[i], arr[start], arr[end]));
          start++;
          end--;
          //去除重复
          while (start < end && arr[start] == arr[start - 1]) {
            start++;
          }
          //去除重复
          while (start < end && arr[end] == arr[end + 1]) {
            end--;
          }
        } else if (sum < 0) {
          start++;
        } else {
          end--;
        }
      }
    }
    return triplets;
  }
}
