class Solution():
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
            if not head:
                return None
            
            # 1. 複製並插入新節點
            curr = head
            while curr:
                new_node = Node(curr.val, curr.next)
                curr.next = new_node
                curr = new_node.next
                
            # 2. 設定 random 指標
            curr = head
            while curr:
                if curr.random:
                    curr.next.random = curr.random.next
                curr = curr.next.next
                
            # 3. 拆分串列
            curr = head
            new_head = head.next
            while curr:
                temp = curr.next
                curr.next = temp.next
                if temp.next:
                    temp.next = temp.next.next
                curr = curr.next
                
            return new_head