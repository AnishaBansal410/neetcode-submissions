class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] pre:prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && dfs(i,visited,adj)){
                return false;
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

    public boolean dfs(int currCourse,int[] visited,List<Integer>[] adj){

        visited[currCourse]=1;

        for(int next:adj[currCourse]){
            if(visited[next]==1){
                return true;
            }
            if(visited[next]==0 && dfs(next,visited,adj)){
                return true;
            }
        }

        visited[currCourse]=2;
        return false;
    }
}
