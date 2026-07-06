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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(right==null && left==null){
            return null;
        }
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}
