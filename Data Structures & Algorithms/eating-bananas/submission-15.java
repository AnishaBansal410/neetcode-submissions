class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;

        for(int i:piles){
            max = Math.max(max,i);
        }

        int min = 1;
        int ans=0;

        while(min<=max){
            int mid = min+(max-min)/2;

            if(isValid(piles,mid,h)){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] piles, int k, int h) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile)/ k;
            if(pile%k!=0){
                hours++;
            }
            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
