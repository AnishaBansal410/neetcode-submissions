class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(); // Min-heap

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        // Keep only the k largest values.
        if (pq.size() > k) {
            pq.poll(); // Remove the smallest among them.
        }

        // Smallest of the k largest = kth largest overall.
        return pq.peek();
    }
}