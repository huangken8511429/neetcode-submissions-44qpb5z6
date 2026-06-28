# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

        # 1. 找中點
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # 2. 反轉後半段,並從中點切開
        second = slow.next
        slow.next = None
        pre = None
        while second:
            nxt = second.next
            second.next = pre
            pre = second
            second = nxt
        # pre 現在是後半段(反轉後)的頭

        # 3. 交錯合併
        first, second = head, pre
        while second:
            n1, n2 = first.next, second.next
            first.next = second
            second.next = n1
            first, second = n1, n2


            