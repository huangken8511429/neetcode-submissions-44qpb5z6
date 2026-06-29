# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        p0 = dummy = ListNode(next=head)

        n = 0
        cur = head
        while cur:
            cur = cur.next
            n += 1

        while n - k >= 0:
            n -= k
            cur = p0.next
            pre = None

            for _ in range(k):
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            nxt = p0.next
            p0.next.next = cur
            p0.next = pre
            p0 = nxt

        return dummy.next                   
