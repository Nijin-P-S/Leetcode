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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(q.size() > 1){
            TreeNode cur = q.poll();
            if(cur == null){
                q.add(null);
                continue;
            }
            if(q.peek() == null){
                ans.add(cur.val);
            }
            if(cur.left != null)q.add(cur.left);
            if(cur.right != null)q.add(cur.right);
        }
        return ans;
    }
}