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
    private int height(TreeNode root){
        if(root == null)
            return 0;
        int left = root.left != null ? height(root.left):0;
        int right = root.right != null ? height(root.right) : 0;
        
        return 1+Math.max(left, right);
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right) > 1)
            return false;
        else{
            boolean leftPart = isBalanced(root.left);
            boolean rightPart = isBalanced(root.right);
            return leftPart && rightPart;
        }
    }
}