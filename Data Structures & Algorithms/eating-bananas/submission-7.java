class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int sum=0;

        for(int i:piles){
            sum+=i;
        }

        int st=1,end=piles[piles.length-1];

        int ans = Integer.MAX_VALUE;

        while(st<=end){
            int mid = st+(end-st)/2;
            
            if(isValid(piles,mid,h)){
                ans = Math.min(ans,mid);
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
    
    public boolean isValid(int[] piles,int k,int h){

        int i = piles.length-1;
        int hours = 0;
        while(i>=0){
            if(piles[i]>k){
                hours+=(piles[i] + k - 1) / k;
                i--;
            }
            else{
                hours++;
                i--;
            }
            if(hours>h){
                return false;
            }
        }
        return true;
    }
}
