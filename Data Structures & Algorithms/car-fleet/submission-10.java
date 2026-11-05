class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] pair = new int[n][2];

        for(int i=0;i<n;i++){
            pair[i] = new int[]{position[i],speed[i]};
        }

        Arrays.sort(pair,(a,b)->b[0]-a[0]);

        double time = 0.0;
        int fleets=0;

        for(int i=0;i<n;i++){
            double currTime = (double)(target-pair[i][0])/pair[i][1];
            if(currTime>time){
                fleets++;
                time=currTime;
            }
        }

        return fleets;
    }
}
