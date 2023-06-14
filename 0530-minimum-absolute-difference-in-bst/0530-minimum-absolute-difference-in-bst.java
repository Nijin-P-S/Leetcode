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
    private void inorder(TreeNode root, int[] ans, int[] prev){
        if(root == null)
            return;
        inorder(root.left,ans, prev);
        ans[0] = Math.min(ans[0], Math.abs(root.val - prev[0]));
        prev[0] = root.val;
        inorder(root.right, ans, prev);
    }
    public int getMinimumDifference(TreeNode root) {
        int ans[] = {Integer.MAX_VALUE};
        int[] prev = {Integer.MAX_VALUE};
        inorder(root, ans, prev);
        return ans[0];
    }
}