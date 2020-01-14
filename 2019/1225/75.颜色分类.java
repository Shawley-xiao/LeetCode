/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length;
        for (int i = 0; i < r; i++) {
            if (nums[i] == 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            } else if (nums[i] == 2) {
                int temp = nums[r - 1];
                nums[r - 1] = nums[i];
                nums[i] = temp;
                r--;
                i--;
            }

        }
    }
}
// @lc code=end

