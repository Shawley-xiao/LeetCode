import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
// @lc code=end

