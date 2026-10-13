class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                ans[j++]=nums[q.peek()];
            }
        }
        return ans;
    }
}
