class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.effort-b.effort);
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist = new int[heights.length][heights[0].length];
        
        for(int[] i:dist){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        pq.offer(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.r==heights.length-1 && curr.c==heights[0].length-1){
                return curr.effort;
            }

            if(curr.effort>dist[curr.r][curr.c]){
                continue;
            }

            for(int[] direction:directions){
                int nx = direction[0]+curr.r;
                int ny = direction[1]+curr.c;

                if(nx<0||ny<0||nx>=heights.length||ny>=heights[0].length){
                    continue;
                }

                int diff = Math.abs(heights[curr.r][curr.c]-heights[nx][ny]);
                int newEffort = Math.max(diff,curr.effort);

                if(newEffort<dist[nx][ny]){
                    dist[nx][ny]=newEffort;
                    pq.offer(new Node(nx,ny,newEffort));
                }
            }
        }

        return 0;
    }
}

class Node{
    int r;
    int c;
    int effort;

    public Node(int r,int c,int effort){
        this.r=r;
        this.c=c;
        this.effort=effort;
    }
}