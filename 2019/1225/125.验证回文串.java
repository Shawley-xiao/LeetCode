/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch <= 'z' && ch >= 'a')
            || (ch <= 'Z' && ch >= 'A')
            || (ch <= '9' && ch >= '0')) {
                sb.append(ch);
            }
        }

        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }
}
// @lc code=end

