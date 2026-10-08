class Solution {
    public int leastInterval(char[] tasks, int n) {

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] freq = new int[26];

        for(int i=0;i<tasks.length;i++){
            freq[Character.toLowerCase(tasks[i])-'a']++;
        }

        for(int i : freq){
            if(i!=0){
                pq.offer(i);
            }
        }

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            while(!q.isEmpty() && q.peek()[1]<=time){
                pq.offer(q.poll()[0]);
            }
            if(!pq.isEmpty()){
                int curr = pq.poll();
                curr-=1;
                if(curr>0){
                    q.offer(new int[]{curr,time+n+1});
                }  
                if(!q.isEmpty() && q.peek()[1]==time){
                    pq.offer(q.poll()[0]);
                }
            }
        }

        return time;
    }
}
