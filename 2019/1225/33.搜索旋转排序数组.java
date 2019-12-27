/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {

    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ?0 :-1;
        }

        int rotate_index = find_rotate_index(0, nums.length - 1);
        if (nums[rotate_index] == target) {
            return rotate_index;
        }

        if (rotate_index == 0) {
            return search(0, nums.length - 1);
        }

        if (target < nums[0]) {
            return search(rotate_index, nums.length - 1);
        }

        return search(0, rotate_index);
    }

    private int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }

    private int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

