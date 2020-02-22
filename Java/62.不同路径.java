import java.util.Map;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }
        
        String key = String.valueOf(m) + "-" + String.valueOf(n);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int paths = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(key, paths);
        return paths;
    }
}
// @lc code=end

