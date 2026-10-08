class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] distance = new int[r][c];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] d:distance){
            Arrays.fill(d,Integer.MAX_VALUE);
        }

        distance[0][0]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(distance[curr.r][curr.c]<curr.dist){
                continue;
            }
            for(int[] d : directions){
                int nx = d[0]+curr.r;
                int ny = d[1]+curr.c;

                if(nx<0 || ny<0 || nx>=r || ny>=c){
                    continue;
                }

                int newDist = Math.abs(heights[curr.r][curr.c]-heights[nx][ny]);
                newDist = Math.max(newDist,distance[curr.r][curr.c]);
                if(newDist<distance[nx][ny]){
                    distance[nx][ny]=newDist;
                    pq.offer(new Pair(nx,ny,distance[nx][ny]));
                }
            }
        }

        return distance[r-1][c-1];
    }
}

class Pair{
    int r;
    int c;
    int dist;

    Pair(int r,int c,int dist){
        this.r=r;
        this.c=c;
        this.dist=dist;
    }
}