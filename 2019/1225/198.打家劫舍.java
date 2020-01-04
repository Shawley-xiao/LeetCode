/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int currentMax = 0;
        for (int x : nums) {
            int temp = currentMax;
            currentMax = Math.max(preMax + x, currentMax);
            preMax = temp;
        }

        return currentMax;
    }
}
// @lc code=end

