class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Set<Integer>[] pre = new HashSet[numCourses];
        for(int i=0;i<numCourses;i++){
            pre[i] = new HashSet<>();
            adj[i] = new ArrayList<>();
        }
        for(int[] i : prerequisites){
            adj[i[0]].add(i[1]);
            indegree[i[1]]++;
        }
        int processed=0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            processed++;
            for(int next : adj[curr]){
                pre[next].addAll(pre[curr]);
                pre[next].add(curr);
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(pre[query[1]].contains(query[0]));
        }
        return res;
    }
}