class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int ans=0;
        while(i<j){
            int weight=people[i]+people[j];
            if(weight<=limit){
                i++;
                j--;
            }
            else{
                j--;
            }
            ans++;
        }
        if(i==j){
            ans++;
        }
        return ans;
    }
}