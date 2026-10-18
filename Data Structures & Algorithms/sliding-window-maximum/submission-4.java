class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peek()<i-k+1){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[j++]=nums[dq.peek()];
            }
        }
        return ans;
    }
}
