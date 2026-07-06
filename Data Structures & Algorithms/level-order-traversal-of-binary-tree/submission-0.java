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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
                arr.add(tmp.val);
            }
            ans.add(arr);
        }
        return ans;
    }
}
