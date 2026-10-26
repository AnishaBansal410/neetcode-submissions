class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = minDepth(i, adj);
            minHeight = Math.min(minHeight, heights[i]);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (heights[i] == minHeight) {
                ans.add(i);
            }
        }

        return ans;
    }

    private int minDepth(int start, List<Integer>[] adj) {
        int depth = 0;
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int next : adj[curr]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return depth;
    }
}