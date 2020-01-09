import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String val = i % 15 == 0 ? "FizzBuzz" :i % 5 == 0 ?"Buzz" :i % 3 == 0 ?"Fizz" :String.valueOf(i);
            list.add(val);
        }

        return list;
    }
}
// @lc code=end

