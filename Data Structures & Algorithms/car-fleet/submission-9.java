class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int fleets = 0;

        int[] dist = new int[position.length];
        int[][] pair = new int[position.length][2];

        for(int i=0;i<position.length;i++){
            dist[i] = target - position[i];
            pair[i] = new int[]{dist[i],speed[i]};
        }
        
        Arrays.sort(pair,(a,b)->a[0]-b[0]);

        double currTime = 0.0;

        for(int[] p:pair){

            double t = (double)p[0]/p[1];

            if(t>currTime){
                currTime = t;
                fleets++;
            }
        }

        return fleets;
    }
}
