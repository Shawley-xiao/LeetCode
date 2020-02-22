import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<String>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (isOperator(str)) {
                String r = stack.pop();
                String l = stack.pop();
                int res = operatorResult(l, r, str);
                stack.push(String.valueOf(res));
            } else {
                stack.push(str);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }

        return false;
    }

    private int operatorResult(String l, String r, String str) {
        Integer lv = Integer.valueOf(l);
        Integer rv = Integer.valueOf(r);
        if (str.equals("+")) {
            return lv + rv;
        } else if (str.equals("-")) {
            return lv - rv;
        } else if (str.equals("*")) {
            return lv * rv;
        } else {
            return lv / rv;
        }
    }
}
// @lc code=end

