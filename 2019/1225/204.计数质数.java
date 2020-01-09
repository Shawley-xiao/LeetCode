/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrimes[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }

        return count;
    }
}
// @lc code=end

