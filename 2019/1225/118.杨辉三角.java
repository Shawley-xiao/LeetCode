import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            list.add(subList);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    List<Integer> prev = list.get(i - 1);
                    subList.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }

        return list;
    }
}
// @lc code=end

