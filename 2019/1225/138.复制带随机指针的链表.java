import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            if (map.containsKey(p)) {
                break;
            }

            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {
            Node curr = map.get(p);
            curr.next = map.get(p.next);
            curr.random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}
// @lc code=end

