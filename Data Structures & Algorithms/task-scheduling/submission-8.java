class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int time=0;

        int[] freq = new int[26];

        for(char c:tasks){
            freq[c-'A']++;
        }

        for(int i:freq){
            if(i!=0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            while(!q.isEmpty() && q.peek()[1]<=time){
                pq.offer(q.poll()[0]);
            }

            if(!pq.isEmpty()){
                int curr = pq.poll();
                curr--;
                if(curr>0){
                    q.offer(new int[]{curr,time+n+1});
                }
            }
        }

        return time;
    }
}
