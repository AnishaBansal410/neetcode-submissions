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

    int ans = -1;
    int cap = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    public void inorder(TreeNode root,int k){
        if(root==null || ans!=-1){
            return;
        }
        inorder(root.left,k);
        cap++;
        if(cap==k){
            ans=root.val;
        }
        inorder(root.right,k);
    }
}
