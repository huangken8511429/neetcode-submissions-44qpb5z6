# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return 
        slow = head
        fast = head.next

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        second = slow.next
        slow.next = prev = None
        while second:
            nxt = second.next
            second.next = prev
            prev = second
            second = nxt

        slow = head

        while prev:
            next1, next2 = slow.next, prev.next
            slow.next = prev
            prev.next = next1
            slow = next1
            prev = next2
                    
