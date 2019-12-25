class lc21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode orginalNode = null;
        ListNode nextNode = null;
        while (l1 != null || l2 != null) {
            ListNode minNode = null;
            if (l1 != null && l2 == null) {
                minNode = l1;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                minNode = l2;
                l2 = l2.next;
            } else {
                if (l1.val <= l2.val) {
                    minNode = l1;
                    l1 = l1.next;
                } else {
                    minNode = l2;
                    l2 = l2.next;
                }
            }

            ListNode newNode = new ListNode(minNode.val);
            if (orginalNode == null) {
                orginalNode = newNode;
            } else if (nextNode == null) {
                nextNode = newNode;
                orginalNode.next = newNode;
            } else {
                nextNode.next = newNode;
                nextNode = newNode;
            }
        }

        return orginalNode;
    }
}