class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;
        Arrays.sort(people);
        int st=0,end=people.length-1;

        while(st<=end){
            if(people[end]+people[st]>limit){
                end--;
            }
            else{
                st++;
                end--;
            }
            boats++;
        }

        return boats;
    }
}