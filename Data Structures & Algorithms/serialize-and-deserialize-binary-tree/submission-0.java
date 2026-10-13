public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                ans.append("N,");
                continue;
            }

            ans.append(curr.val).append(",");
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("N")) {
            return null;
        }

        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (!vals[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.left);
            }
            i++;

            if (!vals[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}