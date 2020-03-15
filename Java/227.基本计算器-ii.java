import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }

                if (sign == '+') {
                    stack.push(num);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int i : stack) {
            num += i;
        }

        return num;
    }
}
// @lc code=end

