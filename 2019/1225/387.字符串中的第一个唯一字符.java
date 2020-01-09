import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        Set<String> map = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.contains(String.valueOf(temp))) {
                continue;
            }

            if (i == s.length() - 1) {
                return i;
            }

            for (int j = i + 1; j < s.length(); j++) {
                char next = s.charAt(j);
                if (temp == next) {
                    map.add(String.valueOf(next));
                    break;
                }

                if (j == s.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

