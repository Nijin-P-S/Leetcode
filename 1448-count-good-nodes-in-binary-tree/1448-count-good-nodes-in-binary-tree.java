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
    public void goodNodes(TreeNode root, int maxVal, int count[]){
        if(root == null)
            return;
        if(root.val >= maxVal)
            count[0]++;
        int curMax = Math.max(maxVal, root.val);
        goodNodes(root.left, curMax, count);
        goodNodes(root.right, curMax, count);
    }
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        count[0] = 0;
        int maxVal = Integer.MIN_VALUE;
        goodNodes(root, maxVal, count);
        
        return count[0];
    }
}