class KthLargest {

    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        cap = k;

        for(int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size()>cap){
            pq.poll();
        }

        return pq.peek();
    }
}
