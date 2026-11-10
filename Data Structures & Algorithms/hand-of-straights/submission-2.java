class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i=0;i<hand.length;i++){
            if(map.get(hand[i])>0){
                for(int j=hand[i];j<hand[i]+groupSize;j++){
                    if(!map.containsKey(j) || map.get(j)<=0){
                        return false;
                    }
                    map.put(j,map.get(j)-1);
                }
            }
        }

        return true;
    }
}
