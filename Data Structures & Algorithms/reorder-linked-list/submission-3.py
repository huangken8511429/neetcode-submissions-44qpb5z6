# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        right = slow.next
        slow.next = prev = None

        while right:
            nxt = right.next
            right.next = prev
            prev = right
            right = nxt

        cur = head

        while prev:
            nxt1, nxt2 = cur.next, prev.next
            cur.next = prev
            prev.next = nxt1
            cur, prev = nxt1, nxt2    
