import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        List<ListNode> prevList = new ArrayList<>();
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            prevList.add(prev);
            prev = curr;
            curr = curr.next;
        }

        prev = prevList.get(prevList.size() - n);
        prev.next = prev.next.next;
        return dummy.next;
    }
}
// @lc code=end

