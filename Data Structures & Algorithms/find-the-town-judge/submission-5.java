class Solution {
    public int findJudge(int n, int[][] trust) {
        // Safe optimization: A judge requires at least n - 1 trust relationships
        if (trust.length < n - 1) {
            return -1;
        }
        
        // Single array tracks net trust score: (indegree - outdegree)
        int[] trustScores = new int[n + 1];
        
        for (int[] edge : trust) {
            trustScores[edge[0]]--; // Outgoing trust reduces score
            trustScores[edge[1]]++; // Incoming trust increases score
        }
        
        // The judge must have a net score of exactly n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}

