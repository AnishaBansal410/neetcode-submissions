class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(visited, adj, 0);

        for(boolean seen:visited){
            if(!seen){
                return false;
            }
        }
        return true;
    }

    public void dfs(boolean[] visited,List<List<Integer>> adj,int i){
        visited[i]=true;
        for(int neighbor:adj.get(i)){
            if(!visited[neighbor]){
                dfs(visited,adj,neighbor);
            }
        }
    }
}
