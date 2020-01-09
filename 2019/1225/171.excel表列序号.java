/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 'A' + 1;
            res += num * Math.pow(26, n - 1 - i);
        }

        return res;
    }
}
// @lc code=end

