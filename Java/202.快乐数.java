/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public int digitSquareSum(int n) {
        int sum = 0, temp = 0;
        while (n != 0) {
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }

        return sum;
    }
}
// @lc code=end

