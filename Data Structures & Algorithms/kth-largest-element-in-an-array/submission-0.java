class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.offer(i);
        }
        int i=1;
        int ans=0;
        while(i<=k){
            ans = pq.poll();
            i++;
        }
        return ans;
    }
}
