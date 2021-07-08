class Solution {
    //算法：单调栈
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                    stack.pop();
                }
                stack.push(i);
            }
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[size - i - 1] = stack.pop();
        }
        return arr;
    }
}