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
class Node{
    TreeNode treeNode;
    Integer row, col;

    Node(TreeNode cur, Integer row, Integer col){
        this.treeNode = cur;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private void vertical(TreeMap<Integer, List<Node>> map, TreeNode root, int row, int col){
        if(root == null)
            return;

        if(!map.containsKey(col)){
            List<Node> curList = new ArrayList<>();
            curList.add(new Node(root, row, col));
            map.put(col, curList);
        }
        else{
            List<Node> curList = map.get(col);
            curList.add(new Node(root, row, col));
            map.put(col, curList);
        }
        vertical(map, root.left, row+1, col-1);
        vertical(map, root.right, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        vertical(map, root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Node> list : map.values()){
            Collections.sort(list, (a,b)->{
                if(a.row < b.row){
                    return -1;
                }
                else if(a.row == b.row){
                    if(a.col < b.col)
                        return -1;
                    else if(a.col == b.col){
                        if(a.treeNode.val < b.treeNode.val)
                            return -1;
                        else 
                            return 1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }
            });
            
            List<Integer> cur = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                cur.add(list.get(i).treeNode.val);
            }
            
            ans.add(cur);
        }
        
        return ans;
    }
}