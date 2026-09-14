class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # 使用 self.prev 讓它在遞迴中可以被共用與修改
        self.prev = float('-inf')
        
        def inorder(node):
            if not node:
                return True
            
            # 1. 走左子樹
            if not inorder(node.left):
                return False
            
            # 2. 檢查當前節點：必須大於前一個節點值
            if node.val <= self.prev:
                return False
            self.prev = node.val # 更新前一個節點值
            
            # 3. 走右子樹
            return inorder(node.right)
            
        return inorder(root)