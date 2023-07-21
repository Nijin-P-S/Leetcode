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
    private int sum(TreeNode root, int sum){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            return sum+root.val;
        }
        
        int left = 0, right = 0;
        if(root.left != null)
            left = sum(root.left, (sum+root.val)*10);
        if(root.right != null)
            right = sum(root.right, (sum+root.val)*10);
        
        return left+right;
    }
    
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
}