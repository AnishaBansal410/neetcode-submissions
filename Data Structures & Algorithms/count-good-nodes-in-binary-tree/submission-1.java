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
        if(root==null){
            return 0;
        }
        return countGood(root,root.val);
    }

    public int countGood(TreeNode root,int minVal){
        if(root==null){
            return 0;
        }

        if(root.val<minVal){
            return countGood(root.left,minVal)+countGood(root.right,minVal);
        }

        return 1+countGood(root.left,root.val)+countGood(root.right,root.val);
    }
}
