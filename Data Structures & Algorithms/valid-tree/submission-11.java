class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }

        boolean[] visited = new boolean[n];

        List<Integer>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);

        visited[0]=true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : adj[curr]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next]=true;
                }
            }
        }

        for(boolean b : visited){
            if(!b){
                return false;
            }
        }

        return true;
    }
}
