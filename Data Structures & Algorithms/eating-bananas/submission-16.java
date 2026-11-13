class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st=1;
        int end=0;

        for(int i:piles){
            end=Math.max(end,i);
        }

        int ans = 0;
        
        while(st<=end){
            int mid = st+(end-st)/2;

            if(isValid(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] piles,int k,int h){
        long hours=0;

        for(int i=0;i<piles.length;i++){
            hours+=piles[i]/k;
            if(piles[i]%k!=0){
                hours++;
            }

            if(hours>h){
                return false;
            }
        }

        return hours<=h;
    }
}
