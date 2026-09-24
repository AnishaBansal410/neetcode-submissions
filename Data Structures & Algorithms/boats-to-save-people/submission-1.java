class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int i=0,j=people.length-1;

        while(i<=j){
            int currWeight = people[i]+people[j];
            if(currWeight>limit){
                ans++;
                j--;
            }
            else{
                ans++;
                j--;
                i++;
            }
        }
        return ans;
    }
}