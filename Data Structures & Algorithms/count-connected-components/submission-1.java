class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int ans = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int next : adj[curr]){
                        if(!visited[next]){
                            visited[next]=true;
                            q.offer(next);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}

