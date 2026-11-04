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

    HashMap<TreeNode,Integer> map = new HashMap<>();

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        map.put(root,1+Math.max(depth(root.left),depth(root.right)));
        return map.get(root);
    }
}
