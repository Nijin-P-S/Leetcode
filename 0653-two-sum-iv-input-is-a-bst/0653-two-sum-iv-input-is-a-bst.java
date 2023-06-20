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
    private boolean getInorder(TreeNode root, HashSet<Integer> inorder, int k){
        if(root == null)
            return false;
        boolean left = getInorder(root.left, inorder, k);
        if(inorder.contains(k-root.val))
            return true;
        inorder.add(root.val);
        boolean right = getInorder(root.right, inorder, k);
        
        return left || right;
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> inorder = new HashSet<>();
        return getInorder(root, inorder, k);
    }
}