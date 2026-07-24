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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        
        while (!queue.isEmpty()) {
          List<Integer> a = new ArrayList<>();
          for (int i = queue.size(); i > 0; i--) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                a.add(node.val);
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
                
            }
        }
        if (!a.isEmpty()) {
          ans.add(a);
        }
          
        }
        return ans;
    }
}
