import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingdown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingdown = !goingdown;
            }

            curRow += goingdown ?1 :-1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : list) {
            ret.append(sb);
        }

        return ret.toString();
    }
}
// @lc code=end

