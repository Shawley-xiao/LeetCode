import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegress[cp[0]]++;
        } 

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) {
                    continue;
                }
                
                if (--indegress[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end

