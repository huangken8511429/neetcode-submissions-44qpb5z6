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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] nums = new int[1];
        dfs(root, nums);
        return nums[0];    
    }
    private int dfs(TreeNode root, int[] nums) {
        if (root == null) return 0;
        int left = dfs(root.left, nums);
        int right = dfs(root.right, nums);
        nums[0] = Math.max(nums[0], left + right);

        return 1 + Math.max(left, right);
    }
}
