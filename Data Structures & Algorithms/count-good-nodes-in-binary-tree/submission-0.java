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
        return goodNodes(root,root.val);
    }

    public int goodNodes(TreeNode root,int minValue){
        if(root==null){
            return 0;
        }
        if(root.val<minValue){
            return goodNodes(root.left,minValue)+goodNodes(root.right,minValue);
        }
        return 1+goodNodes(root.left,root.val)+goodNodes(root.right,root.val);
    }
}
