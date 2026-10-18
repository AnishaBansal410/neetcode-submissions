class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] pairs = new int[position.length][2];

        for(int i=0;i<position.length;i++){
            pairs[i] = new int[]{position[i],speed[i]};
        }

        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        int fleets=0;

        double maxTime=0.0;

        for(int i=0;i<pairs.length;i++){
            double time = (double)(target-pairs[i][0])/pairs[i][1];
            if(time>maxTime){
                fleets++;
                maxTime=time;
            }
        }

        return fleets;
    }
}

