class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap: Stores the point array. Sorts descending by squared distance.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            pq.offer(point);
            
            // If the heap exceeds size k, remove the point furthest away
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Extract the k closest points from the heap into the final array
        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        
        return ans;
    }
}
