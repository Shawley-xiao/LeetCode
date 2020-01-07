/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        StringBuffer sb = new StringBuffer(t);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            int index = sb.indexOf(String.valueOf(cs));
            if (index >= 0) {
                sb = sb.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

