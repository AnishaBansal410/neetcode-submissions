class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0){
            return -1;
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int potentialJudge = 1;
        for(int[] edge:trust){
            if(edge[0]==potentialJudge){
                potentialJudge++;
            }
            if(!map.containsKey(edge[0]))
                map.put(edge[0],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }
        for(Map.Entry<Integer,ArrayList<Integer>> e : map.entrySet()){
            if(!e.getValue().contains(potentialJudge)){
                return -1;
            }
        }
        return potentialJudge;
    }
}