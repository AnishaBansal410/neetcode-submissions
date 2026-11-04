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

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr==null){
                sb.append("N,");
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
        
        String[] str = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();

        if(str.length==0){
            return null;
        }

        if(str[0].equals("N")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);

        int i=1;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(i<str.length && !str[i].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(curr.left);
            }
            i++;

            if(i<str.length && !str[i].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(str[i]));
                q.offer(curr.right);
            }
            i++;

        }

        return root;
    }
}
