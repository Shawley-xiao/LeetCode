/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int base = 0, sign = 1, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '-' ?-1 :1;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ?Integer.MAX_VALUE :Integer.MIN_VALUE;
            }

            base = base * 10 + (str.charAt(i++) - '0');
        }

        return base * sign;
    }
}
// @lc code=end

