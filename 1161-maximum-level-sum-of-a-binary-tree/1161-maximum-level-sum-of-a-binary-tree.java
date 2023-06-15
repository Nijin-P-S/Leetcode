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
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return -1;
        
        int level = 0, maxSum = Integer.MIN_VALUE, ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int curSum = 0;
            level++;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                curSum+=cur.val;
                if(cur.left != null)q.add(cur.left);
                if(cur.right != null)q.add(cur.right);
            }
            if(curSum > maxSum){
                maxSum = curSum;
                ans = level;
            }
        }
        return ans;
    }
}