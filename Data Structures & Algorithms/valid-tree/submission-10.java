class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length!=n-1){
            return false;
        }

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int reached = 0;
        boolean[] visited = new boolean[n];

        q.offer(0);
        reached++;
        visited[0]=true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : adj[curr]){
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    reached++;
                }
            }
        }

        return reached==n;
    }
}
