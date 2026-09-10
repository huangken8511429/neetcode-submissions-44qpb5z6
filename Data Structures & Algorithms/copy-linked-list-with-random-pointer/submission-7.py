"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        cur = head
        while cur:
            new_Node = Node(cur.val, cur.next)
            cur.next = new_Node
            cur = cur.next.next

        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next

        cur = head
        new_Head = cur.next
        while cur:
            temp = cur.next
            cur.next = temp.next
            if temp.next:
                temp.next = temp.next.next
            cur = cur.next
        return new_Head                      
