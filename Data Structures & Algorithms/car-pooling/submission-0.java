class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        int currPassengers=0;

        for(int i=0;i<trips.length;i++){
            int st = trips[i][1];
            int end = trips[i][2];
            int passengers = trips[i][0];

            while(!pq.isEmpty() && pq.peek()[0]<=st){
                currPassengers-=pq.poll()[1];
            }

            currPassengers+=passengers;

            if(currPassengers>capacity){
                return false;
            }

            pq.offer(new int[]{end,passengers});
        }

        return true;
    }
}