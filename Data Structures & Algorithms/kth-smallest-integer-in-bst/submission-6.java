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

    int ct=0;
    int ans=-1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    public void inorder(TreeNode root,int k){
        if(root==null || ans!=-1){
            return;
        }
        inorder(root.left,k);
        ct++;
        if(ct==k){
            ans=root.val;
        }
        inorder(root.right,k);
    }
}
