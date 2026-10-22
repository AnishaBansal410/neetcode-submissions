class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:stones){
            pq.offer(i);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            if(first-second>0){
                pq.offer(first-second);
            }
        }

        return !pq.isEmpty() ? pq.peek() : 0;
    }
}
