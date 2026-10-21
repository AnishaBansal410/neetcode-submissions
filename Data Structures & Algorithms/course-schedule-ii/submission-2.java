class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        ArrayList<Integer> order = new ArrayList<>();
        int processed=0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                order.add(i);
                q.offer(i);
                processed++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next:adj[curr]){
                indegree[next]--;
                if(indegree[next]==0){
                    processed++;
                    q.offer(next);
                    order.add(next);
                }
            }
        }

        return processed==numCourses ? order.stream().mapToInt(Integer::intValue).toArray():new int[]{}; 
    }
}
