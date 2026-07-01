class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;
        int[] netGas = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
            netGas[i]=gas[i]-cost[i];
        }
        if(totalGas<totalCost){
            return -1;
        }
        int start=0;
        int sum=0;
        for(int i=0;i<netGas.length;i++){
            sum+=netGas[i];
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
        return start;
    }
}
