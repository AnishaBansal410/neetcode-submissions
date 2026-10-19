class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()!=0){
                pq.offer(e.getValue());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time=0;

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
