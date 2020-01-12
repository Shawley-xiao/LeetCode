import java.util.HashSet;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet> rows = new ArrayList<>();
        ArrayList<HashSet> cols = new ArrayList<>();
        ArrayList<HashSet> boxs = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            boxs.add(new HashSet<Character>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }

                HashSet<Character> row = rows.get(i);
                HashSet<Character> col = cols.get(j);
                HashSet<Character> box = boxs.get((i / 3 ) * 3 + j / 3);
                if (row.contains(num) || col.contains(num) || box.contains(num)) {
                    return false;
                }

                row.add(num);
                box.add(num);
                col.add(num);
            }
        }

        return true;
    }
}
// @lc code=end

