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
    private void flatten(TreeNode root, ArrayList<TreeNode> inorder){
        if(root == null)
            return;
        inorder.add(root);
        flatten(root.left, inorder);

        flatten(root.right, inorder);
    }
    
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> inorder = new ArrayList<>();
        flatten(root, inorder);
        

        for(int i=0; i<inorder.size(); i++){
            inorder.get(i).left = null;
            if(i == inorder.size()-1){
                inorder.get(i).right = null;
            }
            else{
                inorder.get(i).right = inorder.get(i+1);
            }
        }
        return ;
    }
}