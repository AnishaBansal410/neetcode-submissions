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
    public int goodNodes(TreeNode root) {
        return count(root,Integer.MIN_VALUE);
    }

    public int count(TreeNode root,int val){
        if(root==null){
            return 0;
        }
        if(root.val<val){
            return count(root.left,val)+count(root.right,val);
        }

        return 1+count(root.left,root.val)+count(root.right,root.val);
    }
}
