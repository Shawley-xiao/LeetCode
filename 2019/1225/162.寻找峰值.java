
/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        
        int mid = (low + high) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return findPeak(nums, low, mid);
        } else {
            return findPeak(nums, mid + 1, high);
        }
    }
}
// @lc code=end

