class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = (List<Integer>[]) new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(prerequisites,visited,path,i,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] prerequisites,boolean[] visited,boolean[] path,int i,List<Integer>[] adj){
        visited[i]=true;
        path[i]=true;
        for(Integer neighbor:adj[i]){
            if(!visited[neighbor]){
                if(dfs(prerequisites,visited,path,neighbor,adj)){
                    return true;
                }
            }
            if(path[neighbor]){
                return true;
            }

        }
        path[i]=false;
        return false;
    }
}
