class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] pre:prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(adj,visited,i)){
                    return false;
                }
            }
        }
        return true;
        // Queue<Integer> q = new ArrayDeque<>();
        // int processed=0;
        // for(int i=0;i<numCourses;i++){
        //     if(indegree[i]==0){
        //         q.offer(i);
        //         processed++;
        //     }
        // }

        // while(!q.isEmpty()){
        //     int curr = q.poll();

        //     for(int next : adj[curr]){
        //         indegree[next]--;
        //         if(indegree[next]==0){
        //             q.offer(next);
        //             processed++;
        //         }
        //     }
        // }

        // return processed==numCourses;
    }

    public boolean dfs(List<Integer>[] adj,int[] visited,int currCourse){
        visited[currCourse] = 1;

        for(int next : adj[currCourse]){
            if(visited[next]==1){
                return true;
            }
            if(visited[next]==0 && dfs(adj,visited,next)){
                return true;
            }
        }
        visited[currCourse]=2;
        return false;
    }
}
