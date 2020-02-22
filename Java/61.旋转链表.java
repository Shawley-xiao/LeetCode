import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode dumNode = new ListNode(0);
        ListNode curNode = dumNode;
        int length = list.size();
        int begin = length - k % length, end = 2 * length - k % length;
        for (int i = begin; i < end; i++) {
            curNode.next = list.get(i % length);
            curNode = curNode.next;
        }
        
        curNode.next = null;

        return dumNode.next;
    }
}
// @lc code=end

