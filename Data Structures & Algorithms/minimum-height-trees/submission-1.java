class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int minHeight=Integer.MAX_VALUE;

        int[] heights = new int[n];

        for(int i=0;i<n;i++){
            int x = depth(i,adj,new boolean[n]);
            heights[i] = x;
            minHeight = Math.min(minHeight,x);
        }

        for(int i=0;i<n;i++){
            if(heights[i]==minHeight){
                ans.add(i);
            }
        }

        return ans;
    }

    public int depth(int root,List<Integer>[] adj,boolean[] visited){
        visited[root]=true;
        
        Queue<Integer> q = new ArrayDeque<>();

        int height=0;

        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                for(int next:adj[curr]){
                    if(!visited[next]){
                        visited[next]=true;
                        q.offer(next);
                    }
                }
            }
            height++;
        }

        return height;
    }   
}