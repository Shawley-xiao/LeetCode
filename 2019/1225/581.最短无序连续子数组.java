/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }

        return r - l < 0 ?0 :r - l + 1;
    }
}
// @lc code=end

