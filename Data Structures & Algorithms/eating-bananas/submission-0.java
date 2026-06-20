class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ans=0;
        int i=1,j=piles[piles.length-1];
        while(i<=j){
            int mid=i+(j-i)/2;
            if(canEat(piles,mid,h)){
                ans=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }

    public boolean canEat(int[] piles,int k,int h){
        int i=piles.length-1;
        int time=0;
        while(i>=0){
            time+=piles[i]/k;
            if(piles[i]%k!=0){
                time++;
            }
            if(time>h){
                return false;
            }
            i--;
        }
        return true;
    }
}
