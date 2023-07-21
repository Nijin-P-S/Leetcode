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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean prev = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(prev == false && cur.left != null){
                    return false;
                }
                else if(cur.left == null)
                    prev = false;
                else
                    queue.add(cur.left);
                if(prev == false && cur.right != null){
                    return false;
                }
                else if(cur.right == null)
                    prev = false;
                else
                    queue.add(cur.right);
            }
        }
        return true;
    }
}