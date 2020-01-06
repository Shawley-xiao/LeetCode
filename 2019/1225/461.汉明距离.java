/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                res++;
            }
            
            num = num >> 1;
        }

        return res;
    }
}
// @lc code=end

