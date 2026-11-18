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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return ans;
    }

    public int maxSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = Math.max(0,maxSum(root.left));
        int right = Math.max(0,maxSum(root.right));

        ans = Math.max(ans,left+right+root.val);

        return root.val+Math.max(left,right);
    }
}
