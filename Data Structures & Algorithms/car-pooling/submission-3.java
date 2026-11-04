class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        int passengers = 0;

        int i=0;

        while(i<trips.length){
            while(!pq.isEmpty() && pq.peek()[2]<=trips[i][1]){
                passengers-=pq.poll()[0];
            }
            passengers+=trips[i][0];
            if(passengers>capacity){
                return false;
            }
            pq.offer(trips[i]);
            i++;
        }

        return true;
    }
}