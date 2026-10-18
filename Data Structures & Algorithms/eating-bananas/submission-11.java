class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ans=0;
        int st=1;
        int end=piles[piles.length-1];

        while(st<=end){
            int mid = st+(end-st)/2;

            if(isValid(piles,h,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] piles,int h, int k){
        int time=0;
        for(int i=piles.length-1;i>=0;i--){
            time+=piles[i]/k;
            if(piles[i]%k!=0){
                time++;
            }
            if(time>h){
                return false;
            }
        }
        if(time>h){
            return false;
        }
        return true;
    }
}
