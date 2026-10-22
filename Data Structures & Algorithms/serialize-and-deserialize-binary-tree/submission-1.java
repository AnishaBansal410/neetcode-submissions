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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr==null){
                sb.append("N").append(",");
                continue;
            }

            sb.append(String.valueOf(curr.val)).append(",");
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(",");

        if(arr.length==0 || arr[0].equals("N")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int st=1;

        while(st<arr.length){
            TreeNode curr = q.poll();
            if(!arr[st].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(arr[st]));
                q.offer(curr.left);
            }
            st++;
            if(st<arr.length && !arr[st].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(arr[st]));
                q.offer(curr.right);
            }
            st++;
        }

        return root;
    }
}
