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

    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return diameter;
    }

    public void diameter(TreeNode root){
        if(root==null){
            return;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        diameter = Math.max(diameter,leftDepth+rightDepth);

        diameter(root.left);
        diameter(root.right);
    }

    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(depth(node.left),depth(node.right));
    }
}
