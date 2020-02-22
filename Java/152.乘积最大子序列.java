import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], n = nums.length, l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
// @lc code=end

