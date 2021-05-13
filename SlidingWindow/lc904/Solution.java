import java.util.Map;

public class Solution {
    public int twoTypesFruit(int[] fruits) {
        int start = 0, maxLen = 0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        for (int end = 0; end < fruits.length; end++) {
            fruitMap.put(fruits[end], fruitMap.getOrDefault(fruits[end], 0));
            while (fruitMap.size() > 2) {
                fruitMap.put(fruits[start], fruitMap.get(fruits[start]) - 1);
                if (fruitMap.get(fruits[start]) == 0) {
                    fruitMap.remove(fruits[start]);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
