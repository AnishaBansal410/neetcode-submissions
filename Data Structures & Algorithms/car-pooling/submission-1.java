class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int currPassengers=0;

        for(int[] trip:trips){
            while(!pq.isEmpty() && pq.peek()[2]<=trip[1]){
                currPassengers-=pq.poll()[0];
            }
            currPassengers+=trip[0];
            if(currPassengers > capacity){
                return false;
            }
            pq.offer(trip);
        }

        return true;
    }
}