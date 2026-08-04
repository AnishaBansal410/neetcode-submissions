class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] course : prerequisites){
            adj[course[1]].add(course[0]);
            indegree[course[0]]++;
        }

        int processed = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                ans.add(i);
                
            }
        }

        while(!q.isEmpty()){
            int currCourse = q.poll();
            processed++;
            for(int nextCourse : adj[currCourse]){
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0){
                    q.offer(nextCourse);
                    ans.add(nextCourse);
                    // processed++;
                }
            }
        }

        if(processed!=numCourses){
            return new int[]{};
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
