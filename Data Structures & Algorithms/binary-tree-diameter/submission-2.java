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
        if(root==null){
            return 0;
        }
        int currDia = maxDepth(root.left)+maxDepth(root.right);
        diameter=Math.max(currDia,diameter);
        diameter=Math.max(diameter,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));

        return diameter;
    }

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
