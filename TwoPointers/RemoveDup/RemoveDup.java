package TwoPointers.RemoveDup;

public class RemoveDup {
  public static int removeDup(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    // 这里的双指针是i和nextDup，两个指针配合可以在原数组执行替换，最终nextDup会指向
    // 删除重复数字后的arr的最后一个数字的后面的index，所以只需要返回nextDup即为删除重
    // 复数组的长度。
    int nextDup = 1;
    for (int i = 1; i < arr.length; i++) {
      //i在遍历中自动向后走，nextDup满足条件才会向后走
      if (arr[i] != arr[nextDup - 1]) {
        arr[nextDup] = arr[i];
        nextDup++;
      }
    }
    return nextDup;
  }
}
