class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1
        
        l = ListNode(l1.val)
        if l2.val < l1.val:
            l = ListNode(l2.val)
            return self.startMerge(l1, l2.next, l, l)

        return self.startMerge(l1.next, l2, l, l)

    def startMerge(self, l1, l2, l, result):
        if not l1 and not l2:
            return result

        if not l1 and l2:
            l.next = ListNode(l2.val)
            return self.startMerge(l1, l2.next, l.next, result)
        
        if l1 and not l2:
            l.next = ListNode(l1.val)
            return self.startMerge(l1.next, l2, l.next, result)

        if l1.val <= l2.val:
            l.next = ListNode(l1.val)
            l1 = l1.next
        else:
            l.next = ListNode(l2.val)
            l2 = l2.next
        
        return self.startMerge(l1, l2, l.next, result)
            
        

print(Solution().mergeTwoLists(ListNode(1), ListNode(2)))