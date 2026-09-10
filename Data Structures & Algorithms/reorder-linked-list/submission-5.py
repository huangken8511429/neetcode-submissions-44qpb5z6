# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        dummy = head
        cur = dummy
        #[2, 4, 6, 8]
        #[8 -> 6 -> 4 -> 2 -> 0]

        slow, fast = cur, cur.next

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

        while prev:
            nxt1 = cur.next
            nxt2 = prev.next 
            cur.next = prev
            prev.next = nxt1
            cur = nxt1
            prev = nxt2






        