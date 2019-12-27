/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 1. 根据空格分成字符串数组，数组中的单词前后颠倒顺序
        // 2. 直接遍历在遇到空格时颠倒前一个单词，需要记录前一个空格的位置
        String[] s_array = s.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s_array.length; i++) {
            result.append(new StringBuffer(s_array[i]).reverse().toString() + " ");
        }

        return result.toString().trim();
    }
}
// @lc code=end

