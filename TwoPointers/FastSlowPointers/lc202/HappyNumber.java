public class HappyNumber {
    public boolean happyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquares(slow);
            fast = findSquares(findSquares(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int findSquares(int n) {
        int sum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
