package Amazon;

public class Solution {
    double res = -1;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int[] helper(TreeNode root)  {
        int arr[] = new int[2];
        if (root == null) return arr;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        arr[0] = left[0] + right[0] + root.val;
        arr[1] = left[1] + right[1] + 1;
        res = Math.max(res, (double) arr[0] / arr[1]);
        return arr;
    }
}
