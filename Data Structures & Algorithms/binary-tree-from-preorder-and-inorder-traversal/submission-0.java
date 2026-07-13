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
    int index=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return construct(preorder,inorder,0,inorder.length-1,map);
    }

    public TreeNode construct(int[] preorder, int[] inorder,int start,int end,HashMap<Integer,Integer> map){
        if(start>end){
            return null;
        }
        int root = preorder[index++];
        TreeNode curr = new TreeNode(root);
        int index = map.get(root);

        curr.left = construct(preorder,inorder,start,index-1,map);
        curr.right = construct(preorder,inorder,index+1,end,map);

        return curr;
    }
}
