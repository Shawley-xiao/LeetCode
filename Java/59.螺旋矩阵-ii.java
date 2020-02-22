/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        // int[][] matrix = new int[n][n];
        // int rowBegin = 0, rowEnd = n - 1;
        // int colBegin = 0, colEnd = n - 1;
        // int num = 0;
        // while (rowBegin <= rowEnd && colBegin <= colEnd) {
        //     for (int i = colBegin; i <= colEnd; i++) {
        //         num++;
        //         matrix[rowBegin][i] = num;
        //     }
        //     rowBegin++;

        //     for (int i = rowBegin; i <= rowEnd; i++) {
        //         num++;
        //         matrix[i][colEnd] = num;
        //     }
        //     colEnd--;

        //     if (rowBegin <= rowEnd) {
        //         for (int i = colEnd; i >= colBegin; i--) {
        //             num++;
        //             matrix[rowEnd][i] = num;
        //         }
        //     }
        //     rowEnd--;

        //     if (colBegin <= colEnd) {
        //         for (int i = rowEnd; i >= rowBegin; i--) {
        //             num++;
        //             matrix[i][colBegin] = num;
        //         }
        //     }
        //     colBegin++;
        // }

        // return matrix;

        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;

            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }

        return matrix;
    }
}
// @lc code=end

