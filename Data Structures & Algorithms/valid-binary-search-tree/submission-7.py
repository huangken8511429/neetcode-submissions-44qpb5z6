class Solution:
    # pre = -inf
    def isValidBST(self, root: Optional[TreeNode], left=float('-inf'), right=float('inf')) -> bool:
        # if root is None:
        #     return True
        # left = self.isValidBST(root.left)
        # if not left:
        #     return False
        # x = root.val
        # if x <= pre:
        #     return False
        # self.pre = x    
        # right = self.isValidBST(root.right)

        # return right

        if root is None:
            return True

        if not left < root.val < right:
            return False

        return self.isValidBST(root.left, left, root.val) and self.isValidBST(root.right, root.val, right)            

             