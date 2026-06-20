class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int num:weights){
            sum+=num;
        }
        int i=1;
        int j=sum;
        int ans=sum;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }

    public boolean canShip(int[] weights, int days, int weight){
        int day=0;
        int i=0;
        while(i<weights.length){
            int j=i;
            int currWeight=0;
            while(j<weights.length){
                currWeight+=weights[j];
                if(currWeight==weight){
                    break;
                }
                if(currWeight>weight){
                    j--;
                    break;
                }
                j++;
            }
            day++;
            if(day>days){
                return false;
            }
            i=j+1;
        }
        return true;
    }
}