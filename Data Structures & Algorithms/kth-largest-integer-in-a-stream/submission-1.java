class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        cap = k;
        pq = new PriorityQueue<>(); // Min-heap

        for (int num : nums) {
            if (pq.size() < cap) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < cap) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}