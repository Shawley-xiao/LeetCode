/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int gasSum = 0, costSum = 0;
            for (int j = i; j < length + i; j++) {
                if (costSum > gasSum) {
                    break;
                }

                int index = j % length;
                gasSum += gas[index];
                costSum += cost[index];
                if (j == length + i - 1 && costSum <= gasSum) {
                    return i;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

