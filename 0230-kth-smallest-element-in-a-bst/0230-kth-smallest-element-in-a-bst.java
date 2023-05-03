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
    public void findInorder(TreeNode root, ArrayList<Integer> inorder){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            inorder.add(root.val);
            return;
        }
        findInorder(root.left, inorder);
        inorder.add(root.val);
        findInorder(root.right, inorder);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);
        return inorder.get(k-1);
    }
}