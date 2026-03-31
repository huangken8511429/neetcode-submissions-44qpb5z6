/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans.get(k - 1);        
    }
    private void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        preOrder(root.left, ans);
        ans.add(root.val);
        preOrder(root.right, ans);
    }
}
