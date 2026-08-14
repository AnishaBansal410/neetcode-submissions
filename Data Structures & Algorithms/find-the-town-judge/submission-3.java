class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0){
            return -1;
        }
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for(int[] edge:trust){
            indegree[edge[1]-1]++;
            outdegree[edge[0]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0){
                return i+1;
            }
        }
        
        return -1;
    }
}