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
        if (dfs(visited, adj, 0, -1)) {
            return false;
        }

        for (boolean seen : visited) {
            if (!seen) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(boolean[] visited,List<List<Integer>> adj,int i,int parent){
        visited[i]=true;
        for(int neighbor:adj.get(i)){
            if(visited[neighbor] && parent!=neighbor){
                return true;
            }
            if(!visited[neighbor]){
                if(dfs(visited,adj,neighbor,i)){
                    return true;
                }
            }
        }
        return false;
    }
}
