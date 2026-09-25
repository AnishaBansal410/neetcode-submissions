class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] dist = new int[position.length];
        int[][] pair = new int[position.length][2];

        for(int i=0;i<position.length;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair,(a,b) -> Integer.compare(b[0],a[0]));
        double maxTime = 0.0;
        int fleets=0;

        for(int i=0;i<pair.length;i++){
            double time = (double)(target - pair[i][0])/pair[i][1];
            if(time>maxTime){
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
}
