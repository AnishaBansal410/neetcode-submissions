class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];
        HashSet<Integer>[] links = new HashSet[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
            links[i] = new HashSet<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]);
            indegree[pre[1]]++;
            links[pre[1]].add(pre[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        ArrayList<Integer> order = new ArrayList<>();
        int processed=0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
                processed++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next:adj[curr]){
                indegree[next]--;
                links[next].addAll(links[curr]);
                if(indegree[next]==0){
                    processed++;
                    q.offer(next);
                }
            }
        }
        
        List<Boolean> ans = new ArrayList<>();

        for(int[] query:queries){
            if(links[query[1]].contains(query[0])){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}