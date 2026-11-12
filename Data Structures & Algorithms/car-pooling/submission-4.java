class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        int passengers=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        for(int[] trip:trips){
            while(!pq.isEmpty() && pq.peek()[2]<=trip[1]){
                passengers-=pq.poll()[0];
            }

            passengers+=trip[0];

            if(passengers>capacity){
                return false;
            }

            pq.offer(trip);

        }

        return true;
    }
}