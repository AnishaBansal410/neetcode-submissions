class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        for(int i:gas){
            totalGas+=i;
        }

        int totalCost=0;
        for(int i:cost){
            totalCost+=i;
        }

        if(totalGas<totalCost){
            return -1;
        }

        int[] diff = new int[gas.length];

        for(int i=0;i<gas.length;i++){
            diff[i]=gas[i]-cost[i];
        }

        int st=0;
        
        int currGas=0;

        for(int i=0;i<diff.length;i++){
            currGas+=diff[i];
            if(currGas<0){
                currGas=0;
                st=i+1;
            }
        }

        return st;
    }
}
