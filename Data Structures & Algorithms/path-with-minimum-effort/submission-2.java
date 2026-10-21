class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        for(int i=0;i<heights.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        dist[0][0]=0;
        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(dist[curr.r][curr.c]<curr.dist){
                continue;
            }
            
            dist[curr.r][curr.c] = curr.dist;

            for(int[] direction : directions){
                int nx = direction[0]+curr.r;
                int ny = direction[1]+curr.c;

                if(nx<0||ny<0||nx>=heights.length||ny>=heights[0].length){
                    continue;
                }

                int x = Math.max(dist[curr.r][curr.c],Math.abs(heights[nx][ny]-heights[curr.r][curr.c]));

                if(x<dist[nx][ny]){
                    dist[nx][ny] = x;
                    pq.offer(new Pair(nx,ny,dist[nx][ny]));
                }
            }
        }

        return dist[heights.length-1][heights[0].length-1];
    }
}

class Pair{
    int r;
    int c;
    int dist;

    Pair(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.dist=d;
    }
}