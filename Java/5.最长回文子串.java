/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        //1. 双指针遍历s，得到子字符串如果颠倒顺序后相同的则为回文, 返回最长的回文字符串
        // String longest = "";
        // for (int i = 0; i < s.length(); i++) {
        //     if (longest.length() >= s.length() - i) {
        //         return longest;
        //     }

        //     for (int j = s.length(); j > i; j--) {
        //         String subString = s.substring(i, j);
        //         if (subString.equals(new StringBuffer(subString).reverse().toString())) {
        //             if (longest.length() < subString.length()) {
        //                 longest = subString;
        //             }

        //             break;
        //         }
        //     }
        // }

        // return longest;

        // 中心扩展法
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendCenter(s, i, i);
            int len2 = expendCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expendCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
             L--;
             R++;
        }

        return R - L - 1;
    }
}
// @lc code=end

