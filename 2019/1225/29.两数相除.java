/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int num1 = Math.abs(dividend), num2 = Math.abs(divisor), res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((num1 >>> i) - num2 >= 0) {
                res += 1 << i;
                num1 -= num2 << i;
            }
        }

        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}
// @lc code=end

