class Solution {
    public int[] getOrder(int[][] tasks) {
        
        for(int i=0;i<tasks.length;i++){
            tasks[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }

        Arrays.sort(tasks,(a,b)->a[0]!=b[0] ? a[0]-b[0] : a[2]-b[2]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
        a[1]!=b[1] ? a[1]-b[1] : a[2]-b[2]);

        int[] ans = new int[tasks.length];

        int i=0;
        int j=0;

        int time = 0;

        while(i<tasks.length || !pq.isEmpty()){
            while(i<tasks.length && tasks[i][0]<=time){
                pq.offer(tasks[i]);
                i++;
            }

            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                time+=curr[1];
                ans[j++]=curr[2];
            }
            else{
                time = tasks[i][0];
            }
        }

        return ans;
    }
}