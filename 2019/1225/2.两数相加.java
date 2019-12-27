/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = null;
        ListNode currentNode = null;
        int over = 0;
        while (l1 != null || l2 != null) {
            int sumVal = l1.val + l2.val;
            ListNode nextNode = new ListNode((sumVal + over) % 10);
            if (currentNode == null) {
                currentNode = nextNode;
                newNode = nextNode;
            } else {
                currentNode.next = nextNode;
            }

            currentNode = currentNode.next;
            over = (sumVal + over) / 10;
            if (l1.next != null) {
                l1 = l1.next;
            }

            if (l2.next != null) {
                l2 = l2.next;
            }
        }

        return newNode;
    }
}
// @lc code=end

