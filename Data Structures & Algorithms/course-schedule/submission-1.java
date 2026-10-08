class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int processed=0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                processed++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neighbor:adj.get(curr)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.offer(neighbor);
                    processed++;
                }
            }
        }
        if(processed==numCourses){
            return true;
        }
        return false;
    }
}
