class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];

        for(int i=0;i<position.length;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair,(a,b)->b[0]-a[0]);

        int fleets=0;

        double time = 0;

        for(int[] p : pair){
            double t = (double)(target-p[0])/p[1];
            if(t>time){
                fleets++;
                time=t;
            }
        }

        return fleets;
    }
}
