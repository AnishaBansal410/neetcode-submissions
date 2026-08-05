class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            Pair p = new Pair(e.getKey(),e.getValue());
            pq.offer(p);
        }
        int i=0;
        while(i<k){
            ans[i++]=pq.poll().val;
        }
        return ans;
    }
}

class Pair{
    int val;
    int freq;

    public Pair(int val,int freq){
        this.val=val;
        this.freq=freq;
    }
}