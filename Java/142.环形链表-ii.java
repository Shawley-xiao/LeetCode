/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode pStart = head;
        ListNode pIntersect = intersect;
        while (pStart != pIntersect) {
            pStart = pStart.next;
            pIntersect = pIntersect.next;
        }

        return pStart;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (fast == low) {
                return fast;
            }
        }

        return null;
    }
}
// @lc code=end

