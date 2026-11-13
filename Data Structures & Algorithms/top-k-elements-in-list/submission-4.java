class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.offer(new int[]{e.getKey(),e.getValue()});
        }

        int[] ans = new int[k];
        int i=0;

        while(i<k){
            ans[i++]=pq.poll()[0];
        }

        return ans;
    }
}
