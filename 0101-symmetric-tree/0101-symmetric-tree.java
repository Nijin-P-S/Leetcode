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
    private boolean isSymmetric(TreeNode leftMirror, TreeNode rightMirror){
        if(leftMirror == null && rightMirror == null)
            return true;
        if((leftMirror == null && rightMirror != null) || (leftMirror != null && rightMirror == null) || (leftMirror.val != rightMirror.val))
            return false;
        
        return isSymmetric(leftMirror.left, rightMirror.right) && isSymmetric(leftMirror.right, rightMirror.left);
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
}