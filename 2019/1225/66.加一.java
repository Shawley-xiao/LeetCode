/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int over = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + over;
            if (i == digits.length - 1) {
                sum++;
            } else if (over == 0) {
                break;
            }

            over = sum / 10;
            digits[i] = sum % 10;
        }

        if (over == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }

            return newDigits;
        }

        return digits;
    }
}
// @lc code=end

