import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void backTrack(String s, int l, ArrayList<String> currLst, List<List<String>> ret) {
        if (currLst.size() > 0 && l >= s.length()) {
            List<String> r = (ArrayList<String>) currLst.clone();
            ret.add(r);
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    currLst.add(Character.toString(s.charAt(i)));
                } else {
                    currLst.add(s.substring(l, i+1));
                }
                backTrack(s, i+1, currLst, ret);
                currLst.remove(currLst.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        if (l == r) {
            return true;
        }

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;r--;
        }

        return true;
    }
}
// @lc code=end

