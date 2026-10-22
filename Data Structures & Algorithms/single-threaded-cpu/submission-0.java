class Solution {
    public int[] getOrder(int[][] tasks) {

        for(int i=0;i<tasks.length;i++){
            tasks[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }

        Arrays.sort(tasks,((a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[2]-b[2]));

        int time = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]!=b[1] ? a[1]-b[1] : a[2]-b[2]);

        int i=0;
        int[] res = new int[tasks.length];
        int j=0;

        while(!pq.isEmpty() || i<tasks.length){

            while(i<tasks.length && tasks[i][0]<=time){
                pq.offer(new int[]{tasks[i][0],tasks[i][1],tasks[i][2]});
                i++;
            }

            if(pq.isEmpty()){
                time=tasks[i][0];
            }
            else{
                int[] next = pq.poll();
                time+=next[1];
                res[j++]=next[2];
            }

        }
        return res;
    }
}