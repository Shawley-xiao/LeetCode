
/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, w, y, x, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] word, int y, int x, int i) {
        if (word.length == i) {
            return true;
        }

        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }

        if (board[y][x] != word[i]) {
            return false;
        }

        board[y][x] ^= 256;
        boolean exist = exist(board, word, y, x + 1, i + 1)
                      || exist(board, word, y, x - 1, i + 1)
                      || exist(board, word, y + 1, x, i + 1)
                      || exist(board, word, y - 1, x, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}
// @lc code=end

