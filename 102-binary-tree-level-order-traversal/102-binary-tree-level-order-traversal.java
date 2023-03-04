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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> lvl = new LinkedList<>();
        
        lvl.add(root);
        lvl.add(null);
        List<Integer> order = new ArrayList<>();
        while(!lvl.isEmpty()){
            TreeNode cur = lvl.remove();            
            if(cur == null){
                ans.add(order);
                if(lvl.isEmpty())
                    break;
                else{
                    lvl.add(null);
                    order = new ArrayList<>();
                }
            }
            else{
                order.add(cur.val);
                if(cur.left != null)
                    lvl.add(cur.left);
                if(cur.right != null)
                    lvl.add(cur.right);
            }
        }
        return ans;
        
    }
}