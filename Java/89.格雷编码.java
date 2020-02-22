import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            list.add(i ^ i>>1);
        }

        return list;
    }
}
// @lc code=end

