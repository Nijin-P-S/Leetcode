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
    public int goodNodes(TreeNode root, int maxVal){
        if(root == null)
            return 0;
        int res = root.val>=maxVal?1:0;
        int curMax = Math.max(maxVal, root.val);
        return res + goodNodes(root.left, curMax) + goodNodes(root.right, curMax);
    }
    public int goodNodes(TreeNode root) {

        int maxVal = Integer.MIN_VALUE;
        return goodNodes(root, maxVal);

    }
} 