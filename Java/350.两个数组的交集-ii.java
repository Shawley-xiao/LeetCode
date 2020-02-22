import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer key = nums1[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer key = nums2[i];
            if (map.containsKey(key) && map.get(key) != 0) {
                list.add(key);
                map.put(key, map.get(key) - 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end

